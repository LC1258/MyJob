package com.lwj.summary;

import java.util.Scanner;

public class GCDAndLCM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int gcd = gcd(a, b);
        System.out.println(gcd);
        int lcm = lcm(a, b);
        System.out.println(lcm);
    }

    /**
     * 计算 a b 的最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    /**
     * 计算 a b 的最小公倍数
     * @param a
     * @param b
     * @return
     */
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
