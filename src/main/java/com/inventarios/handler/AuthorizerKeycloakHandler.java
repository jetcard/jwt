package com.inventarios.handler;

import com.inventarios.handler.keycloak.AuthorizerKeycloakAbstractHandler;
import com.inventarios.handler.keycloak.AuthorizationInfo;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AuthorizerKeycloakHandler extends AuthorizerKeycloakAbstractHandler {

    @Override
    protected String extractAuthToken(APIGatewayProxyRequestEvent input) {
        Map<String, String> headers = input.getHeaders();
        if (headers != null) {
            String authHeader = headers.get("Authorization");
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
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
                List<String> roles = extractRolesFromClaims(claims);
                String userId = claims.getSubject();
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
        return roles;
    }

    @Override
    protected void addAuthorizationHeaders(AuthorizationInfo authInfo, APIGatewayProxyRequestEvent request) {
        if (authInfo != null) {
            request.getHeaders().put("X-UserId", authInfo.getUserId());
            request.getHeaders().put("X-Roles", String.join(",", authInfo.getRoles()));
        }
    }
}