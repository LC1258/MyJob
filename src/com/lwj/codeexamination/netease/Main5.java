package com.lwj.codeexamination.netease;

import java.util.Arrays;

public class Main5 {
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();*/
        int target = 100;
        int[] nums = {47, 59, 42};
        int res = getMaxWeight(nums, target);
        System.out.println(res);
    }
    private static int getMaxWeight(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i]  = sum[i - 1] + nums[i];
            if (sum[i] > target) {
                return sum[i - 1];
            }
        }
        return  -1;
    }
}
