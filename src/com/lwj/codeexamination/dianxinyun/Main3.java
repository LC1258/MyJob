package com.lwj.codeexamination.dianxinyun;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] ss = str.split(",");
        int n = ss.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int res = getMaxSum(nums);
        System.out.println(res);
    }

    public static int getMaxSum(int[] nums) {
        int len = nums.length;
        if(len <= 1){
            return len==0 ? 0 : nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2;i < len; i++){
            dp[i] = Math.max(dp[i - 1],(nums[i] + dp[i - 2]));
        }
        return dp[len - 1];
    }
}
