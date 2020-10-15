package com.lwj.codeexamination.aqiyi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);
        int n = in.nextInt();
        int res = countZero(n);
        System.out.println(res);
    }
    private static int countZero(int n) {
        if (n < 5) {
            return 0;
        } else {
            return (n / 5 + countZero(n / 5));
        }
    }
}
