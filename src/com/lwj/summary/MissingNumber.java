package com.lwj.summary;

/**
 * 寻找消失的元素
 * 给定0,1,2,3...,n中的 n 个数的序列，找出 0,...,n 中没有出现的在序列中的那个数
 */
public class MissingNumber {

    /**
     * 使用异或运算完成操作，索引与数据构成一对，可以使用异或操作找到缺失的元素
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        res ^= n;
        for (int i = 0; i < n; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

    /**
     * 利用数学思想，通过总和相减找到对应的缺失 的数据
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int expect = (0 + n) * (n + 1) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return expect - sum;
    }

    /**
     * 使用数学思维，采用相减，但是再求和的时候有可能整型溢出
     * 在计算和的过程中直接执行相减运算
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int n = nums.length;
        int res = 0;
        res += n - 0;
        for (int i = 0; i < n; i++) {
            res += i - nums[i];
        }
        return res;
    }
}
