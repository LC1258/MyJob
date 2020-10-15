package com.lwj.codeexamination.bilibili2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        int[] res = SpiralMatrix(matrix);
        System.out.println(Arrays.toString(res));
    }

    public static int[] SpiralMatrix (int[][] matrix) {
        if (matrix.length == 0) {
            return new int[] {};
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[] res = new int[n * m];
        if (m == 0) {
            return new int[] {};
        }
        int layers = (Math.min(n, m) - 1) / 2 + 1;
        int z = 0;
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < m - i; k++) {
                res[z++] = matrix[i][k];
            }
            for (int j = i + 1; j < n - i; j++) {
                res[z++] = matrix[j][m - i - 1];
            }
            for (int k = m - i - 2; (k >= i) && (n - i - 1 != i); k--) {
                res[z++] = matrix[n - i - 1][k];
            }
            for (int j = n - i - 2; (j > i) && (m - i - 1 != j) ; j--) {
                res[z++] = matrix[j][i];
            }
        }
        return res;
    }
}
