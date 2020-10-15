package com.lwj.summary;

import java.util.Arrays;

public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {6, 3, 5, 10, 11, 2, 9, 18, 13, 7, 4, 8, 12};
        int res=  lengthOfLIS1(nums);
        System.out.println(res);
    }

    /**
     * 使用动态规划的方式解决最长递增子序列的问题
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(nums, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 使用二分查找的方式实现，原理跟玩扑克牌差不多，将总的数据分成好几堆
     * 最后堆的总数就是最长递增子序列
     * @param nums
     * @return
     */
    public static int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        int[] top = new int[len];
        int piles = 0;
        for (int i = 0; i < len; i++) {
            int poker = nums[i];
            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == piles) piles++;
            top[left] = poker;
        }
        return piles;
    }
}
