package com.lwj.codeexamination.tencent;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            if (n <= 18) {
                System.out.println(n);
                return;
            }
            int res = getValue(n);
            System.out.println(res);
        }
    }
    private static int getValue(int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n / 2; i++) {
            int v1 = value(i);
            int v2 = value(n - i);
            int sum = v1 + v2;
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    private static int value(int n) {
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            sum += temp;
            n /= 10;
        }
        return sum;
    }
}
