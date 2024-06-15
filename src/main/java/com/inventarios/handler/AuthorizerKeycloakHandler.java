package com.inventarios.handler;

import com.inventarios.handler.keycloak.AuthorizerKeycloakAbstractHandler;
import com.inventarios.handler.keycloak.AuthorizationInfo;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.inventarios.util.MyLambdaLogger;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AuthorizerKeycloakHandler extends AuthorizerKeycloakAbstractHandler {
    private static final LambdaLogger logger = new MyLambdaLogger();
    @Override
    protected String extractAuthToken(APIGatewayProxyRequestEvent input) {
        Map<String, String> headers = input.getHeaders();
        logger.log("headers = "+headers);
        if (headers != null) {
            String authHeader = headers.get("Authorization");
            logger.log("authHeader = "+authHeader);
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                logger.log("authHeader = "+authHeader.substring(7));
                return authHeader.substring(7);
            }
        }
        return null;
    }

    @Override
    protected AuthorizationInfo validateAuthToken(String authToken) {
        if (authToken != null) {
            try {
                PublicKey keycloakPublicKey = getKeycloakPublicKey();
                if (keycloakPublicKey == null) {
                    throw new RuntimeException("Failed to obtain Keycloak public key");
                }

                JwtParser jwtParser = Jwts.parser()
                        .setSigningKey(keycloakPublicKey);

                /*
                JwtParser jwtParser = Jwts.parserBuilder()
                        .setSigningKey(keycloakPublicKey)
                        .build();
                */

                Claims claims = jwtParser.parseClaimsJws(authToken).getBody();
                logger.log("claims = "+claims);
                List<String> roles = extractRolesFromClaims(claims);
                logger.log("roles =====> "+roles);
                String userId = claims.getSubject();
                logger.log("userId =====> "+userId);
                return new AuthorizationInfo(userId, roles);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private List<String> extractRolesFromClaims(Claims claims) {
        List<String> roles = new ArrayList<>();
        Map<String, Object> realmAccess = (Map<String, Object>) claims.get("realm_access");
        if (realmAccess != null) {
            roles = (List<String>) realmAccess.get("roles");
        }
        logger.log("roles = " + roles);
        return roles;
    }

    @Override
    protected void addAuthorizationHeaders(AuthorizationInfo authInfo, APIGatewayProxyRequestEvent request) {
        if (authInfo != null) {
            logger.log("authInfo = "+authInfo);
            request.getHeaders().put("X-UserId", authInfo.getUserId());
            request.getHeaders().put("X-Roles", String.join(",", authInfo.getRoles()));
            logger.log("request.getHeaders() X-UserId = "+request.getHeaders().get("X-UserId"));
            logger.log("request.getHeaders() X-Roles = "+request.getHeaders().get("X-Roles"));
        } else {
            logger.log("authInfo is null, cannot add authorization headers");
        }
    }
}