package com.esi;



public class determinant {
    
    //function to calculate determinant of matrix
    public static double Determinant(double[][] matrix) {
        double det = 0;
        if (matrix.length == 1) {
            det = matrix[0][0];
        } else if (matrix.length == 2) {
            det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            for (int i = 0; i < matrix.length; i++) {
                double[][] subMatrix = new double[matrix.length - 1][matrix.length - 1];
                for (int j = 1; j < matrix.length; j++) {
                    for (int k = 0; k < matrix.length; k++) {
                        if (k < i) {
                            subMatrix[j - 1][k] = matrix[j][k];
                        } else if (k > i) {
                            subMatrix[j - 1][k - 1] = matrix[j][k];
                        }
                    }
                }
                det += Math.pow(-1, i) * matrix[0][i] * Determinant(subMatrix);
            }
        }
        return det;
    }
    
}
