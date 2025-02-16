package com.banistmo.developer.domain;

public class SkillMatrix {
    private final char[][] matrix;
    private int countSequences = 0;

    public SkillMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public boolean isDeveloper() {
        int rows = matrix.length;
        int cols = matrix[0].length;


        int[][] directions = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};

        System.out.println(" Matriz recibida:");
        printMatrix(matrix);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char currentChar = matrix[i][j];

                for (int[] dir : directions) {
                    if (checkSequence(i, j, dir[0], dir[1], currentChar)) {
                        countSequences++;
                        if (countSequences >= 2) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean checkSequence(int row, int col, int dx, int dy, char letter) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 1; i < 4; i++) {
            int newRow = row + i * dx;
            int newCol = col + i * dy;

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                return false;
            }

            if (matrix[newRow][newCol] != letter) {
                return false;
            }
        }

        return true; 
    }

    private void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
