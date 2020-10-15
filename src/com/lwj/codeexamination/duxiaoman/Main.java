package com.lwj.codeexamination.duxiaoman;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[][] matrix = {
                {'0','#','#'},
                {'#','#','1'},
                {'0','0','0'}
        };
        int row = matrix.length;
        int col = matrix[0].length;
        int k = 2;
        int[][] grids = new int[row][col];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    grids[i][j] = -1;
                } else if (matrix[i][j] == '#') {
                    grids[i][j] = k;
                } else {
                    grids[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(grids[i]));
        }
        System.out.println();
        int res = new Main().leastPathToEnd(grids);
        System.out.println(res);
    }

    private static final int MAXVALUE = 100000;
    public  int leastPathToEnd(int[][] grids) {
        int row = grids.length;
        int col = grids[0].length;
        for (int i = row - 2; i >= 0; i--) {
            if (grids[i + 1][col - 1] != -1) {
                grids[i][col - 1] = 1 + grids[i + 1][col - 1];
            } else {
                grids[i][col - 1] = MAXVALUE;
            }
        }
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(grids[i]));
        }
        System.out.println("+++++++++++++++++++++++");
        for (int i = col - 2; i >= 0; i--) {
            if (grids[row - 1][i + 1] != -1) {
                grids[row - 1][i] = 1 + grids[row - 1][i + 1];
            } else {
                grids[row - 1][i] = MAXVALUE;
            }
        }
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(grids[i]));
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                if (grids[i][j] == -1) {
                    grids[i][j] = MAXVALUE;
                    continue;
                }
                grids[i][j] = 1 + Math.min(grids[i + 1][j], grids[i][j+1]);
            }
        }
        return grids[0][0] >= MAXVALUE ? -1 : grids[0][0];
    }
}
