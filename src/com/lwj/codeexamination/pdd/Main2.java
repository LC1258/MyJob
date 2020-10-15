package com.lwj.codeexamination.pdd;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] matrix = new int[N][M];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = in.nextInt();
                if (matrix[i][j] == 1) {
                    sum++;
                }
            }
        }
        int res = 0;
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = 1;
                    int cur = dfs(matrix, visited, i, j);
                    if (cur > sum) {
                        sum--;
                    }
                    res = Math.max(res, cur);
                    for (boolean[] e : visited) {
                        Arrays.fill(e, false);
                    }
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(res);
    }

    private static int dfs(int[][] matrix, boolean[][] visited, int i, int j) {
        if (i < 0 || i>= matrix.length || j < 0 || j >=matrix[0].length || visited[i][j] || matrix[i][j] == 0) {
            return 0;
        }
        int res = 1;
        visited[i][j] = true;
        res += dfs(matrix, visited, i + 1, j);
        res += dfs(matrix, visited, i - 1, j);
        res += dfs(matrix, visited, i, j + 1);
        res += dfs(matrix, visited, i, j - 1);
        return res;
    }
}
