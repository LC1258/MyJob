package com.lwj.summary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyKMP {
    public static void main(String[] args) {
        String txt = "abaaba";
        String pattern = "aba";
        int[] next = getNext1(pattern);
        System.out.println(Arrays.toString(next));
        System.out.println("=====================================");
        int res = KMP(txt, pattern);
        System.out.println(res);
        System.out.println("=====================================");
        List<Integer> res1 = match(txt, pattern);
        System.out.println(res1);
    }

    private static int[] getNext(String pattern) {
        int n = pattern.length();
        int[] next = new int[n];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < n - 1) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static int KMP(String txt, String pattern) {
        int[] next = getNext(pattern);
        int i = 0, j = 0;
        while (i < txt.length() && j < pattern.length()) {
            if (j == -1 || txt.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pattern.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * 根据模式串得到 next 数组
     * @param pattern
     * @return
     */
    private static int[] getNext1(String pattern) {
        int n = pattern.length();
        int[] next = new int[n];
        int maxLen = 0;
        for (int i = 1; i < n; i++) {
            while (maxLen > 0 && pattern.charAt(maxLen) != pattern.charAt(i)) {
                maxLen = next[maxLen - 1];
            }
            if (pattern.charAt(maxLen) == pattern.charAt(i)) {
                maxLen++;
            }
            next[i] = maxLen;
        }
        return next;
    }

    public static List<Integer> match(String txt, String pattern) {
        int n = txt.length();
        int m = pattern.length();
        List<Integer> res = new ArrayList<>();
        int[] next = getNext1(pattern);
        int count = 0;
        for (int i = 0; i < n; i++) {
            while (count > 0 && pattern.charAt(count) != txt.charAt(i)) {
                count = next[count - 1];
            }
            if (pattern.charAt(count) == txt.charAt(i)) {
                count++;
            }
            if (count == m) {
                res.add(i - m + 1);
                count = next[count - 1];
            }
        }
        return res;
    }
}
