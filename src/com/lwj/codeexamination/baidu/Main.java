package com.lwj.codeexamination.baidu;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int zero = 0;
        int five = 0;
        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            if (temp == 0) {
                zero++;
            } else {
                five++;
            }
        }
        if (zero == 0){
            System.out.println("-1");
        } else if (five < 9) {
            System.out.println(0);
        } else {
            int num = five % 9;
            num = five - num;
            while (num-- > 0) {
                System.out.print(5);
            }
            while (zero-- > 0) {
                System.out.print(0);
            }
        }
    }

    public static String getString(List<Integer> list) {
        int five = 0;
        int zero = 0;
        for (int i = 0; i < list.size(); i++) {
            if (5 == list.get(i)) {
                five++;
            } else if (list.get(i) == 0){
                zero++;
            }
        }
        int n = five / 9;
        if (n == 0 || zero <= 0) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("555555555");
        }
        for (int i = 0; i < zero; i++) {
            sb.append("0");
        }
        return sb.toString();
    }
}
