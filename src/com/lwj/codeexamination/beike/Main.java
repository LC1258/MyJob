package com.lwj.codeexamination.beike;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int M = in.nextInt();
            if (N == 1 || M == 1) {
                int res = getCount(Math.max(M, N));
                System.out.println(res);
            } else {
                int res = Math.min(getCount(M), getCount(N));
                System.out.println(res);
            }
        }
    }

    private static int getCount(int num) {
        if (num <= 2) {
            return num;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return i;
            }
        }
        return num;
    }
}
