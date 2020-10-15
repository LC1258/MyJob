package com.lwj.codeexamination.tencent;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int Q = in.nextInt();
        for (int i = 0; i < Q; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            String ss = s.substring(a - 1, b);
            int res = getLast(ss) + 1;
            System.out.println(res);
        }
    }
    public static int getLast(String s) {
        int n = s.length();
        boolean[][] a = new boolean[n][n];
        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = (i == j);
            }
        }
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && ((i - j) < 2 || a[j+1][i-1])) {
                    a[j][i] = true;
                    if (j == 0) {
                        dp[i] = Math.min(dp[i], 0);
                    } else {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[n-1];
    }
}
