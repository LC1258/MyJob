package com.lwj.codeexamination.bytedance;

import java.util.Scanner;

public class Main {
    //private static final int MAXN = 200000 + 5;
    private static final int mod = 1000000007;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();
        int[][] dp = new int[n+1][3];
        for (int h = 0; h <= 2; h++) {
            dp[1][h] += ((r - h + 3) / 3 - (l - 1 - h + 3) / 3);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int h = 0; h < 3; h++) {
                    dp[i + 1][(j + h) % 3] += dp[i][j] *((r - h + 3) / 3 - (l - 1 - h + 3) / 3);
                    dp[i + 1][(j + h) % 3] %= mod;
                }
            }
        }
        System.out.println(dp[n][0]);
    }
}
