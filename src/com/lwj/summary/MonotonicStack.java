package com.lwj.summary;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 单调栈解决问题：每次新元素入栈之后，栈内的元素是有序的，单调递增或者递减
 * 只处理⼀种典型的问题， 叫做 Next Greater Element
 *  Next Greater Number 的原始问题： 给你⼀个数组， 返回⼀个等
 * ⻓的数组， 对应索引存储着下⼀个更⼤元素， 如果没有更⼤的元素， 就存-1。 不好⽤语⾔解释清楚， 直接上⼀个例⼦：
 * 给你⼀个数组 [2,1,2,4,3]， 你返回数组 [4,2,4,-1,-1]。
 */
public class MonotonicStack {
    public static void main(String[] args) {
        int[] nums = {2,1,2,4,3};
        int[] res = nextGreaterElement(nums);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 求解下一个更大的数 普通数组
     * @param nums
     * @return
     */
    public static int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0 ; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    /**
     * 请根据每日 气温 列表，重新生成一个列表。
     * 对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * @param temperature
     * @return
     */
    public int[] dailyTemperatures(int[] temperature) {
        int[] res = new int[temperature.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=temperature.length - 1; i>= 0; i--) {
            while(!stack.isEmpty() && temperature[stack.peek()] <= temperature[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }

    /**
     * 求解下一个更大的数 循环数组
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i=2*len - 1; i>=0;i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i % len]) {
                stack.pop();
            }
            res[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }
        return res;
    }

    /**
     * 给定两个 没有重复元素 的数组 nums1 和 nums2，其中nums1 是 nums2 的子集。
     * 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     *
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的
     * 第一个比 x 大的元素。如果不存在，对应位置输出 -1

     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElements(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int res[] = new int[len1];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i < len2; i++) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        for(int i=0;i < len1; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
