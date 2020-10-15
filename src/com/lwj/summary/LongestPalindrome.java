package com.lwj.summary;

/**
 * 求最长回文子串
 * 从中心向两边扩展法
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "cbbcd";
        String res = longestPalindrome(s);
        System.out.println(res);
    }
    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int s1 = palindrome(s, i, i);
            int s2 = palindrome(s, i, i + 1);
            res = res.length() > s1 ? res : s.substring(i - (s1-1) / 2, i + s1/2 + 1);
            res = res.length() > s2 ? res : s.substring(i - (s2-1) / 2, i + s2/2 + 1);
        }
        return res;
    }

    private static int palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
