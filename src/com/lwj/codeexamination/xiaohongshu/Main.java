package com.lwj.codeexamination.xiaohongshu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[] res = subSort(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res);
        }
    }
    public static int[] subSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[] {-1, -1};
        }
        int last = -1;
        int first = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            if (arr[i] < max) {
                last = i;
            } else {
                max = Math.max(max, arr[i]);
            }

            if (arr[len - 1 - i] > min) {
                first = len - i - 1;
            } else {
                min = Math.min(min, arr[len - 1 - i]);
            }
        }
        return new int[]{first, last};
    }
    public static int[] subSort1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{-1, -1};
        }
        int max = arr[0];
        int i = 0;
        int right = -1;
        int len = arr.length;

        while (i < len) {
            int temp = arr[i];
            if (temp < max) right = i;
            max = Math.max(max, temp);
            i++;
        }
        int min = arr[len - 1];
        int j = len - 1;
        int left = -1;
        while (j >= 0) {
            int temp = arr[i];
            if (temp > min) left = j;
            min = Math.min(min, temp);
            j--;
        }
        return new int[]{left, right};
    }
    public static int[] subSort2(int[] arr) {
        int a = 0, b = 0, c = 0;
        boolean big = false;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] < arr[b]) {
                c = i;
                if (arr[a] > arr[i]) {
                    for (int j = a; j >= 0; j--) {
                        if (arr[j - 1] <= arr[i]) {
                            break;
                        }
                        a--;
                    }
                }
                big = true;
            }
            if (arr[i] >= arr[b]) {
                b = i;
                if (!big) {
                    a = i;
                }
            }
        }
        if (!big) {
            return new int[]{-1, -1};
        }
        return new int[]{a, c};
    }
}
