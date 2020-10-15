package com.lwj.summary;

import java.util.Arrays;

public class KMP {

    private static int[][] dp;
    private static String pat;
    public KMP(String pat){
        this.pat = pat;
        int M = pat.length();
        // dp[状态][字符]  = 下个状态
        dp = new int[M][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // 影子状态
        int X = 0;
        // 构建状态转移图
        for (int j = 1; j < M; j++) {
            //
            for (int c = 0; c < 256; c++) {
                if (pat.charAt(j) == c) {
                    dp[j][c] = j + 1;
                } else {
                    dp[j][c] = dp[X][c];
                }
                //dp[j][c] = dp[X][c];
            }
            // 当前是状态 j， 遇到字符 txt[i]，
            // pat 应该转移到哪个状态？
            dp[j][pat.charAt(j)] = j + 1;
            // 更新影⼦状态
            // 当前是状态 X， 遇到字符 pat[j]，
            // pat 应该转移到哪个状态？
            X = dp[X][pat.charAt(j)];
        }
    }
    public static void main(String[] args) {
        String s = "ABCDEFG";
        int[] res = getNext2(s);
        System.out.println(Arrays.toString(res));
    }

    private static int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        // pat的初始状态
        int j = 0;
        for (int i = 0; i < N; i++) {
            // 计算pat 的下一个状态
            j = dp[j][pat.charAt(i)];
            // 到达终点，返回结果
            if (j == M) return i - M + 1;
        }
        // 没有到达终点，匹配失败
        return -1;
    }


    private static int[] getNext(String pattern) {
        char[] c = pattern.toCharArray();
        int length = c.length;
        int[] a = new int[length];
        int i, j;
        a[0] = -1;
        i = 0;
        for (j = 1; j < length; j++) {
            i = a[j - 1];
            while (i >= 0 && c[j] != c[i + 1]) {
                i = a[i];
            }
            if (c[j] == c[i + 1]) {
                a[j] = i + 1;
            } else {
                a[j] = -1;
            }
        }
        return a;
    }
    private static int[] getNext1(String pattern) {
        int n = pattern.length();
        int len;
        int[] next = new int[n];
        next[0] = 0;
        for (int i = 1; i < n; i++) {
            len = next[i - 1];
            while (true) {
                if (pattern.charAt(i) == pattern.charAt(len)) {
                    len++;
                    next[i] = len;
                    break;
                } else {
                    if (len > 0) {
                        len = next[len - 1];
                    } else {
                        next[i] = 0;
                        break;
                    }
                }
            }
        }
        return next;
    }

    private static int[] getNext2(String pattern) {
        int m = pattern.length();
        int[] next = new int[m];
        Arrays.fill(next, -1);
        for (int i = 1; i < m; i++) {
            int j = next[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = next[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                next[i] = j + 1;
            }
        }
        return next;
    }
}
