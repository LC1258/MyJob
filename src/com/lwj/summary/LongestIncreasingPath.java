package com.lwj.summary;

public class LongestIncreasingPath {

    private static int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private static int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j, dp));
            }
        }
        return max;
    }

    private static int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j];
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] >= matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], dfs(matrix, x, y, dp));
            }
        }
        return ++dp[i][j];
    }
}
