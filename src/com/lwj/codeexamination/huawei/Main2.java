package com.lwj.codeexamination.huawei;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        System.out.println((2 << 32));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long count = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                if (gcd(i, j) != 1) {
                    count++;
                }
            }
        }
        long total = n * n;
        System.out.println(total - count);
    }
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
}
