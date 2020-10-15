package com.lwj.codeexamination.meituan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        List<int[]> list = new ArrayList<>();
        if (n < 2178) {
            System.out.println(0);
        } else if (n >= 2178 && n < 21978) {
            System.out.println(1);
            System.out.println("2178 8712");
        } else if (n >= 21978 && n < 219978) {
            System.out.println(2);
            System.out.println("2178 8712");
            System.out.println("21978 87912");
        } else if (n >= 219978 && n < 2199978) {
            System.out.println(3);
            System.out.println("2178 8712");
            System.out.println("21978 87912");
            System.out.println("219978 879912");
        } else {
            System.out.println(4);
            System.out.println("2178 8712");
            System.out.println("21978 87912");
            System.out.println("219978 879912");
            System.out.println("2199978 8799912");
        }
        for (int i = 1; i < n; i++) {
            if (isReverse(i)) {
                count++;
                list.add(new int[]{i, getReverse(i)});
            }
        }
        System.out.println(count);
        Collections.sort(list, (a, b) -> (a[0] - b[0]));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)[0] + " " +list.get(i)[1]);
        }
    }
    private static int getReverse(int n) {
        if (n < 0) return -1;
        int res = 0;
        while (n != 0) {
            int temp = n % 10;
            res = res * 10 + temp;
            n /= 10;
        }
        return res;
    }
    private static boolean isReverse(int n) {
        int reverse = getReverse(n);
        return reverse == n * 4;
    }
}
