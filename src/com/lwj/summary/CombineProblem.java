package com.lwj.summary;

import java.util.ArrayList;
import java.util.List;

/**
 * 输⼊两个数字 n, k ， 算法输出 [1..n] 中 k 个数字的所有组合。
 * ⽐如输⼊ n = 4, k = 2 ， 输出如下结果， 顺序⽆所谓， 但是不能包含重复
 * （按照组合的定义， [1,2] 和 [2,1] 也算重复） ：
 * [ [1,2], [1,3], [1,4], [2,3], [2,4], [3,4] ]
 */
public class CombineProblem {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> res = new CombineProblem().combine(n, k);

        System.out.println(res);
    }
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0) {
            return res;
        }
        List<Integer> trace = new ArrayList<>();
        backTrace(n, k,1, trace);
        return res;
    }
    private void backTrace(int n, int k, int start, List<Integer> trace) {
        if (trace.size() == k) {
            res.add(new ArrayList<>(trace));
            return;
        }
        for(int i = start; i <= n; i++) {
            trace.add(i);
            backTrace(n, k,i + 1, trace);
            trace.remove(trace.size() - 1);
        }
    }
}
