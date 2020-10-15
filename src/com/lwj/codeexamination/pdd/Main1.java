package com.lwj.codeexamination.pdd;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        int[][] res = getMatrixWith(matrix);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != n - 1) {
                    System.out.print(res[i][j] + " ");
                } else {
                    System.out.print(res[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static int[][] getMatrixWith(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int r_half = row / 2;
        int c_half = col / 2;
        for (int i = 0; i <= r_half - 1; i++) {
            for (int j = c_half; j <= col - i - 1; j++) {
                matrix[i][j] = 1;
            }
        }
        for (int i = 0; i <= r_half - 1; i++) {
            for (int j = i; j < r_half; j++) {
                matrix[i][j] = 2;
            }
        }
        for (int i = 0; i <= r_half - 1; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] = 3;
            }
        }
        for (int i = r_half; i < row; i++) {
            for (int j = 0; j < col - i; j++) {
                matrix[i][j] = 4;
            }
        }
        for (int i = r_half; i < row; i++) {
            for (int j = row - i -1; j < c_half; j++) {
                matrix[i][j] = 5;
            }
        }
        for (int i = r_half; i < row; i++) {
            for (int j = c_half; j < col; j++) {
                matrix[i][j] = 6;
            }
        }
        for (int i = r_half; i < row; i++) {
            for (int j = i; j < row; j++) {
                matrix[i][j] = 7;
            }
        }
        for (int i = 0; i < r_half; i++) {
            for (int j = col - i - 1; j < col; j++) {
                matrix[i][j] = 8;
            }
        }
        if (row % 2 == 0) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == j || i == row -j -1) {
                        matrix[i][j] = 0;
                    }
                }
            }
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == j || i == row -j -1 || j == c_half || i == r_half) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        return matrix;
    }
    public static void getMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        matrix[0][1] = 2;
        matrix[0][col - 2] = 1;
        matrix[1][0] = 3;
        matrix[row - 2][0] = 4;
        matrix[row - 1][1] = 5;
        matrix[row - 1][col - 2] = 6;
        matrix[row - 2][col - 1] = 7;
        matrix[1][col - 1] = 8;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j != col - 1) {
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}
