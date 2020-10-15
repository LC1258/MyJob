package com.lwj.codeexamination.netease;/*
package lwj.com.help.netease;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();
        */
/*String sA = num2Binary(A);
        String sB = num2Binary(B);
        int difLen = sA.length() - sB.length();
        if (difLen > 0) {
            while (difLen-- > 0) sB =
        }*//*

        int res = getMinB(A, B, n);
        int res = binary2Num("111");
        System.out.println(res);
    }

    private static String num2Binary(int num) {
        StringBuilder ans = new StringBuilder();
        while (num > 0) {
            ans.append(num % 2);
            num /= 2;
        }
        ans.reverse();
        return ans.toString();
    }

    private static int binary2Num(String s) {
        int num = 0, len = s.length(), i = -1;
        while (++i < len) {
            num = num * 2 + s.charAt(i) - '0';
        }
        return num;
    }
}
*/
