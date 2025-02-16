package com.banistmo.developer.infrastructure.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.banistmo.developer.domain.SkillMatrix;
import java.util.HashMap;
import java.util.Map;

public class SkillMatrixHandler implements RequestHandler<Map<String, Object>, Map<String, Object>> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<String, Object> handleRequest(Map<String, Object> input, Context context) {
        Map<String, Object> response = new HashMap<>();
        try {
            String bodyString = (String) input.get("body");
            JsonNode bodyNode = objectMapper.readTree(bodyString);

            if (!bodyNode.has("matrix")) {
                throw new RuntimeException("El JSON de entrada no contiene el campo 'matrix'");
            }

            char[][] matrix = convertJsonToMatrix(bodyNode.get("matrix"));
            SkillMatrix skillMatrix = new SkillMatrix(matrix);
            boolean isDeveloper = skillMatrix.isDeveloper();

            Map<String, Object> responseData = new HashMap<>();
            responseData.put("message", isDeveloper ? "Es" + " " +
                    "developer y bienvenido a Banistmo" : "muchas gracias, pero no cumples"  +
                    " " + "con los requisitos");
            response.put("statusCode", 200);
            response.put("body", convertToJson(Map.of("data", responseData)));
        } catch (Exception e) {
            response.put("statusCode", 400);
            response.put("body", convertToJson(Map.of("data", Map.of("error", "Error en el JSON de entrada: " + e.getMessage()))));
        }
        return response;
    }

    private char[][] convertJsonToMatrix(JsonNode matrixNode) {
        int rows = matrixNode.size();
        int cols = matrixNode.get(0).size();
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = matrixNode.get(i).get(j).asText().charAt(0);
            }
        }
        return matrix;
    }

    private String convertToJson(Map<String, Object> map) {
        try {
            return objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            return "{\"data\": {\"error\": \"Error al procesar la respuesta JSON\"}}";
        }
    }
}
