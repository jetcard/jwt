package com.inventarios.handler.examen.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventarios.bean.EstudianteSession;
import com.inventarios.bean.Examen;
import com.inventarios.handler.examen.ControlBeanNombr;
import com.inventarios.handler.examen.response.ExamenSolucionResponseRest;
import io.quarkus.oidc.UserInfo;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class ExamenSolucionAbstractHandler  implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private static final Map<String, String> headers = new HashMap<>();
    private HttpSession sesion;

    static {
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");
        headers.put("Access-Control-Allow-Origin", "*");
        headers.put("Access-Control-Allow-Headers", "content-type,X-Custom-Header,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token");
        headers.put("Access-Control-Allow-Methods", "POST");
    }

    protected abstract void actualizaRespuestas(APIGatewayProxyRequestEvent request);

    @Inject
    SecurityIdentity securityIdentity;
    @Inject
    UserInfo userInfo;

    @Override
    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent request, final Context context) {
            String path = request.getPath();
            if (path.equals("/users/me")) {
                return handleMeRequest(request, context);
            } else if (path.equals("/users/info")) {
                return handleInfoRequest(request, context);
            } else {
                return new APIGatewayProxyResponseEvent()
                        .withStatusCode(404)
                        .withBody("Resource not found");
            }

/*
        LambdaLogger logger = context.getLogger();
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent().withHeaders(headers);
        ExamenSolucionResponseRest responseRest = new ExamenSolucionResponseRest();
        try{
            // Obtener los parámetros de consulta
            Map<String, String> queryParams = request.getQueryStringParameters();
            String cmdIrA  = queryParams.containsKey("fb_get") ? (queryParams.get("fb_get")) : "";
            String cmdAntr = queryParams.containsKey("fb_antr") ? (queryParams.get("fb_antr")) : "";
            String cmdSigt = queryParams.containsKey("fb_sigt") ? (queryParams.get("fb_sigt")) : "";
            String cmdSigtPlay = queryParams.containsKey("cmd_sigt_play") ? (queryParams.get("cmd_sigt_play")) : "";
            String cmdEval = queryParams.containsKey("fb_eval") ? (queryParams.get("fb_eval")) : "";
            String cmdReport = queryParams.containsKey("fb_report") ? (queryParams.get("fb_report")) : "";
            String cmdImprimir = queryParams.containsKey("fb_imprimir") ? (queryParams.get("fb_imprimir")) : "";

            actualizaRespuestas(request);

            int PAGINA_INICIAL = 0;
            int PAGINA_EXAMEN = 1;
            int PAGINA_RESULTADO = 2;
            int PAGINA_REPORT = 3;
            int PAGINA_IMPRIMIR = 4;
            int PAGINA_JUEGO = 5;
            int pantalla;

            ControlBeanNombr ctrlBean;
            EstudianteSession esb;
            Examen e;

            String output="";
            return response.withStatusCode(200)
                .withBody(output);
        } catch (Exception e) {
            return response
                    .withBody(e.toString())
                    .withStatusCode(500);
        }
*/
    }

    private APIGatewayProxyResponseEvent handleMeRequest(APIGatewayProxyRequestEvent request, Context context) {
        String username = securityIdentity.getPrincipal().getName();
        Map<String, String> responseBody = Map.of("username", username);
        return buildResponse(200, responseBody);
    }
    private APIGatewayProxyResponseEvent handleInfoRequest(APIGatewayProxyRequestEvent request, Context context) {
        Map<String, String> userInfoMap = Map.of(
                "name", userInfo.getName(),
                "first_name", userInfo.getFirstName(),
                "family_name", userInfo.getFamilyName(),
                "display_name", userInfo.getDisplayName(),
                "preferred_username", userInfo.getPreferredUserName(),
                "sub", userInfo.getSubject(),
                "email", userInfo.getEmail()
        );
        return buildResponse(200, userInfoMap);
    }
    private APIGatewayProxyResponseEvent buildResponse(int statusCode, Object body) {
        try {
            String responseBody = new ObjectMapper().writeValueAsString(body);
            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(statusCode)
                    .withHeaders(Map.of("Content-Type", "application/json"))
                    .withBody(responseBody);
        } catch (JsonProcessingException e) {
            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(500)
                    .withBody("Error processing response body");
        }
    }
    private String toJson(Map<String, String> map) {
        return map.entrySet().stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(",", "{", "}"));
    }


}
