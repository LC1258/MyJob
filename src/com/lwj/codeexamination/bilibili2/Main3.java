package com.lwj.codeexamination.bilibili2;

public class Main3 {
    public static void main(String[] args) {
        String str = "aaabbaaac";
        int res = GetFragment(str);
        System.out.println(res);
    }
    public static int GetFragment (String str) {
        // write code here

        int len = str.length();
        int left = 0, right = 0;
        int count = 0;
        while (right < len) {
            char c = str.charAt(right);
            if (str.charAt(left) == c) {
                right++;
                continue;
            }
            left = right;
            count++;
        }
        count++;
        return len / count;
    }
}
