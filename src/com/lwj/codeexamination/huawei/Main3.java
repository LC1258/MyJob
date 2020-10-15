package com.lwj.codeexamination.huawei;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = s.split(",");
        int M = Integer.parseInt(ss[0]);
        int N = Integer.parseInt(ss[1]);
        char[][] matrix = new char[M][N];
        for (int i = 0; i < M; i++) {
            String str = in.nextLine();
            for (int j = 0; j < str.length(); j++) {
                matrix[i][j] = str.charAt(j);
            }
        }
        int res = getNum(matrix);
        System.out.println(res);
    }
    public static int getNum(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 'S') {
                    ++count;
                    dfs(matrix, r, c);
                }
            }
        }
        return count;
    }
    private static void dfs(char[][] matrix, int r, int c) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if ( r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] == 'H') {
            return;
        }
        matrix[r][c] = 'H';
        dfs(matrix, r - 1, c);
        dfs(matrix, r + 1, c);
        dfs(matrix, r, c + 1);
        dfs(matrix, r, c - 1);
    }
}
