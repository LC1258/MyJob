package com.lwj.codeexamination.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int L = in.nextInt();
        int T = in.nextInt();
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        int res = getLastRestTimes(L, T, nums);
        System.out.println(res);
    }
    private static int getLastRestTimes(int L, int T, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        return 1;
    }
}
