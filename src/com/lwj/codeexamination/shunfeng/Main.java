package com.lwj.codeexamination.shunfeng;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int res = getCount(nums);
        System.out.println(res);
    }

    private static int getCount(int[] nums) {
        int n = nums.length;
        int count = 0;
        int k = 0;
        int i, j;
        while (k < n) {
            count++;
            i = k;
            while (i < n && nums[i] == -1) i++;
            if (i > n) {
                return count;
            }
            j = i + 1;
            if(j > n) {
                return count;
            }
            while (nums[j] == -1) j++;

            int d = (nums[j] - nums[i]) / (j - i);
            if ((nums[j] - nums[i]) % (j - i) != 0 || nums[j] - d * (j - k) <= 0) {
                k = j;
                continue;
            }
            k = j + 1;
            while (k < n && nums[j] + d * (k - j) > 0 && (nums[k] == -1 || nums[k] == nums[j] + d * (k-j))) {
                k++;
            }
        }
        return count;
    }
}
