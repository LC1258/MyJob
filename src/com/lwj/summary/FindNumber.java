package com.lwj.summary;

import java.util.Arrays;

public class FindNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,35,2,9,3,49};
        int[] res = findNumbers(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] findNumbers(int[] nums) {
        int len = nums.length;
        int i, max, secondMax;
        max = nums[0];
        secondMax = Integer.MAX_VALUE;
        for (i = 1; i < len; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
            } else {
                if (nums[i] > secondMax) {
                    secondMax = nums[i];
                }
            }
        }
        return new int[]{max, secondMax};
    }
}
