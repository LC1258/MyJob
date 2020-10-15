package com.lwj.codeexamination.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String temp = in.nextLine();
            String[] strs = temp.split(" ");
            list.add(strs);
        }
        List<List<String>> res = letterCombinations(list);
        for (List<String> cur : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = cur.size() - 1; i >= 0; i--) {
                if (i != 0) {
                    sb.append(cur.get(i)).append("-");
                } else {
                    sb.append(cur.get(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
    public static List<List<String>> letterCombinations(List<String[]> strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.size() == 0){
            return res;
        }
        dfs(new ArrayList<>(), strs.size() - 1, res,  strs);
        return res;
    }
    private static void dfs(List<String> sb, int index, List<List<String>> res, List<String[]> strs) {
        if(sb.size() == strs.size()) {
            res.add(new ArrayList<>(sb));
            return;
        }
        ;if (index < 0) return;
        String[] keys = strs.get(index);
        for(String str : keys) {
            sb.add(str);
            dfs(sb, index - 1, res, strs);
            sb.remove(sb.size()-1);
        }
    }
}
    /*public static boolean isCircle(String s) {
        List<Character> list = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (list.contains(ch)) {
                return true;
            }
            list.add(ch);
        }
        return false;
    }*/

