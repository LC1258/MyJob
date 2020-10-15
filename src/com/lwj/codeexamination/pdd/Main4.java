package com.lwj.codeexamination.pdd;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        long[] nums = new long[M];
        for (int i = 0; i < M; i++) {
            nums[i] = in.nextLong();
        }
        for (int i = 1; i <= M ; i++) {
            getCount2(nums, 0, 0, i, 0, M, N);
        }
        System.out.println(ans);
    }
    private static long ans = 0;
    public static void getCount2(long[] k, int pos, int te, int all, long lcm, long N, long M) {
        if (pos == all) {
            int temp = 1;
            for (int i = 1; i < all; i++) {
                temp *= -1;
            }
            ans += temp * (M / lcm);
            return;
        }
        for (int t = te; t < N; t++) {
            long tec = k[t];
            if (pos != 0) {
                long gc = gcd(lcm, tec);
                tec /= gc;
                tec *= lcm;
            }
            getCount2(k,pos + 1, t + 1, all, tec, N, M);
        }
    }
    public static long gcd(long a, long b) {
        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
