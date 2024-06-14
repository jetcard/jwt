package com.inventarios.handler.keycloak;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AuthorizerKeycloakAbstractHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final Map<String, String> headers = new HashMap<>();

    static {
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");
        headers.put("Access-Control-Allow-Origin", "*");
        headers.put("Access-Control-Allow-Headers", "content-type,X-Custom-Header,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token");
        headers.put("Access-Control-Allow-Methods", "POST");
    }

    protected abstract String extractAuthToken(APIGatewayProxyRequestEvent request);

    protected abstract AuthorizationInfo validateAuthToken(String authToken);

    protected abstract void addAuthorizationHeaders(AuthorizationInfo authInfo, APIGatewayProxyRequestEvent request);

    @Override
    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent request, final Context context) {
        LambdaLogger logger = context.getLogger();
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent().withHeaders(headers);
        try {
            String authToken = extractAuthToken(request);
            AuthorizationInfo authInfo = validateAuthToken(authToken);
            addAuthorizationHeaders(authInfo, request);

            /*if (authInfo.isAdmin()) {
                response = adminResource.handleRequest(request, context);
            } else {
                response = userResource.handleRequest(request, context);
            }*/

            return response.withStatusCode(200);
        } catch (Exception e) {
            e.printStackTrace();
            return response.withStatusCode(500);
        }
    }

    public PublicKey getKeycloakPublicKey() {
        try {
            String jwksUrl = "https://examensolucion-u8698.vm.elestio.app/realms/ExamenSolucion/protocol/openid-connect/certs";
            HttpURLConnection connection = (HttpURLConnection) new URL(jwksUrl).openConnection();
            connection.setRequestMethod("GET");

            InputStream responseStream = connection.getInputStream();
            String response = new String(responseStream.readAllBytes(), StandardCharsets.UTF_8);

            return extractPublicKeyFromJson(response);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public PublicKey extractPublicKeyFromJson(String jsonResponse) {
        try {
            Map<String, Object> responseMap = objectMapper.readValue(jsonResponse, new TypeReference<>() {
            });
            List<Map<String, Object>> keys = (List<Map<String, Object>>) responseMap.get("keys");
            if (keys == null || keys.isEmpty()) {
                throw new RuntimeException("No keys found in the JWKS response");
            }
            String modulus = (String) keys.get(0).get("n");
            String exponent = (String) keys.get(0).get("e");

            return createPublicKey(modulus, exponent);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public PublicKey createPublicKey(String modulus, String exponent) {
        try {
            byte[] modBytes = Base64.getUrlDecoder().decode(modulus);
            byte[] expBytes = Base64.getUrlDecoder().decode(exponent);

            BigInteger modBigInt = new BigInteger(1, modBytes);
            BigInteger expBigInt = new BigInteger(1, expBytes);

            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modBigInt, expBigInt);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}