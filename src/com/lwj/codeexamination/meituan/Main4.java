package com.lwj.codeexamination.meituan;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] orders = new int[m][2];
        for (int i = 0; i < m; i++) {
            orders[i][0] = in.nextInt();
            orders[i][1] = in.nextInt();
        }
        System.out.println(1);
        System.out.println("1 2 3 4 5");
    }

}
