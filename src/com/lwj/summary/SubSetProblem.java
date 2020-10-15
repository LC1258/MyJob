package com.lwj.summary;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 输⼊⼀个不包含重复数字的数组， 要求算法输出这些数字的所
 * 有⼦集。
 *  ⽐如输⼊ nums = [1,2,3] ， 你的算法应输出 8 个⼦集， 包含空集和本⾝，
 * 顺序可以不同：
 * [ [],[1],[2],[3],[1,3],[2,3],[1,2],[1,2,3] ]
 */
public class SubSetProblem {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> res = new SubSetProblem().subSets(nums);
        System.out.println(res);
    }

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subSets(int[] nums) {
        List<Integer> trace = new ArrayList<>();
        backTrace(nums, 0, trace);
        return res;
    }
    private void backTrace(int[] nums, int start, List<Integer> trace) {
        res.add(new ArrayList<>(trace));
        for(int i = start; i < nums.length; i++) {
            trace.add(nums[i]);
            backTrace(nums, i + 1, trace);
            trace.remove(trace.size() - 1);
        }
    }
}
