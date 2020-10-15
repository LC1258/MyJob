package com.lwj.codeexamination.beike;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            dp[i][i] = nums[i];
        }
        if (n < 2) {
            System.out.println(n);
        }
        int maxLen = Integer.MAX_VALUE;
        int max_val = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = (dp[i][j - 1] | nums[j]);
                if (dp[i][j] >= max_val) {
                    maxLen = Math.min(maxLen, j - i + 1);
                    max_val = dp[i][j];
                }
            }
        }
        System.out.println(maxLen);
    }
}
