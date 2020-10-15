package com.lwj.codeexamination.beike;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        int res = getCount(str);
        System.out.println(res);
    }

    private static int getCount(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int count = 0;

        int len = str.length();
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                count++;
            }
            left++;
            right--;
        }
        return count;
    }
}
