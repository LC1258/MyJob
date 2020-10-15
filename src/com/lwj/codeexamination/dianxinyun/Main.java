package com.lwj.codeexamination.dianxinyun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*int a, b, c, d;
        for (int i = 0; i < 10000; i++) {
            a = i / 1000;
            b = (i - a * 1000) / 100;
            c = (i - a * 1000 - b * 100) / 10;
            d = i - a * 1000 - b * 100 - c * 10;

            if ((i + b * 1000 + c * 100 + d * 10 + a) == 8888 && d >= 0) {
                System.out.println(a + " " + b + " " + c + " " + d);
            }
        }*/
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        String[] ss1 = s1.split(" ");
        String[] ss2 = s2.split(" ");
        int n = Integer.parseInt(ss1[0]);
        int m = Integer.parseInt(ss1[1]);
        int x = Integer.parseInt(ss1[2]);
        int len = ss2.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(ss2[i]);
        }
        for (int i = 0; i < m; i++) {
            int index = getMinHeight(nums);
            nums[index] += x;
        }
        int index = getMinHeight(nums);
        System.out.println(nums[index]);
    }

    public static int getMinHeight(int[] nums) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                index = i;
                min = nums[i];
            }
        }
        return index;
    }
}
