package com.lwj.codeexamination.bytedance;

import java.util.*;

public class Bytedance {
    public static void main(String[] args) {
        int[] rounds = {1,3,1,2};
        List<Integer> res = mostVisited(4, rounds);
        System.out.println(res);
    }
    private static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> subSets(int[] nums) {
        List<Integer> trace = new ArrayList<>();
        backTrace(nums, 0, trace);
        return res;
    }
    private static void backTrace(int[] nums, int start, List<Integer> trace) {
        res.add(new ArrayList<>(trace));
        for(int i = start; i < nums.length; i++) {
            trace.add(nums[i]);
            backTrace(nums, i + 1, trace);
            trace.remove(trace.size() - 1);
        }
    }
    private static boolean isKth(List<Integer> list, int k) {
        if (list.size() <= 1) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i);
            for (int j = i+1; j < list.size(); j++) {
                int b = list.get(j);
                if ((a + b) % k == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Integer> mostVisited(int n, int[] rounds) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = rounds.length;
        for (int i = 1; i < len; i++) {
            if (rounds[i] > rounds[i - 1]) {
                for (int j = rounds[i - 1]; j <= rounds[i]; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
            } else {
                for (int j = rounds[i]; j < rounds[i - 1]; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
            }
        }
        List<Integer> value = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            value.add(map.get(i));
        }
        Collections.sort(value);
        int max = value.get(value.size() - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (value.get(i) == max) {
                res.add(i);
            }
        }
        return res;
    }

}
