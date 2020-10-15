package com.lwj.summary;

import java.util.ArrayList;
import java.util.List;

public class PermuteProblem {
    public static void main(String[] args) {
        int[] nums = {2,2,3};
        List<List<Integer>> res = new PermuteProblem().permute(nums);
        System.out.println(res);
    }
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> trace = new ArrayList<>();
        backTrace(nums, trace);
        return res;
    }
    private void backTrace(int[] nums, List<Integer> trace) {
        if (trace.size() == nums.length) {
            res.add(new ArrayList<>(trace));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(trace.contains(nums[i])) {
                continue;
            }
            trace.add(nums[i]);
            backTrace(nums, trace);
            trace.remove(trace.size() - 1);
        }
    }
}
