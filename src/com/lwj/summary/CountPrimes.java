package com.lwj.summary;

import java.util.Arrays;

/**
 * 高效计算素数 时间复杂度为最终结果是 O(N * loglogN)，
 */
public class CountPrimes {
    public static void main(String[] args) {
        int n = 8;
        int count = countPrimes(n);
        System.out.println(count);
    }

    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
