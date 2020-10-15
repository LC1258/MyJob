package com.lwj.codeexamination.qunaer;

public class Main {
    public static void main(String[] args) {
        String s1 = "a b c d e f g";
        String s2 = "b d a c f g e";
        int res = getCommonNum(s1, s2);
        System.out.println(res);
    }

    public static int getCommonNum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
