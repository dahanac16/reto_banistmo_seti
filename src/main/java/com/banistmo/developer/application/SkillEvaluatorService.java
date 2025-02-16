package com.banistmo.developer.application;

import com.banistmo.developer.domain.SkillMatrix;

public class SkillEvaluatorService {
    public static String evaluate(char[][] matrix) {
        SkillMatrix skillMatrix = new SkillMatrix(matrix);
        return skillMatrix.isDeveloper() ? "Es " +
                "developer y bienvenido a Banistmo" : "Muchas gracias, pero no cumples " +
                "con los requisitos";
    }
}
