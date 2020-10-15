package com.lwj.codeexamination.meituan;

import java.util.*;

public class Main1 {
    static List<Integer> trace;
    static Set<Integer> searched = new HashSet<>();
    static Set<List<Integer>> allCircles = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextInt();
        List<String[]> list = new ArrayList<>();
        List<String> node = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            String[] strs = str.split(" ");
            for (int j = 0; j < strs.length; j++) {
                if (node.contains(strs[i])) {
                    continue;
                }
                node.add(strs[i]);
            }
            list.add(strs);
        }
        int total = node.size();
        int[][] graphic = new int[total][total];
        for (int i = 0; i < total; i++) {
            
        }
    }
    private static void findCircle(Integer v, int[][] e) {
        int j = trace.indexOf(v);
        if (j != -1) {
            List<Integer> circle = new ArrayList<>();
            while (j < trace.size()) {
                circle.add(trace.get(j));
                j++;
            }
            Collections.sort(circle);
            allCircles.add(circle);
            return;
        }
        trace.add(v);
        for (int i = 0; i < e.length; i++) {
            if (e[v][i] == 1) {
                searched.add(i);
                findCircle(i, e);
            }
        }
        trace.remove(trace.size() - 1);
    }
    private static int findCycle(String[][] edges) {
        if (edges == null || edges.length < 0) {
            return 0;
        }
        Map<String, String> map = new HashMap<>();
        map.put(edges[0][1], edges[0][0]);
        for (int i = 0; i < edges.length; i++) {
            if (map.containsKey(edges[i][0])) {
                String temp = map.get(edges[i][0]);
                map.remove(edges[i][0]);
                map.put(edges[i][1],temp);
            }
            map.put(edges[i][0], edges[i][0]);
        }
        return map.size();
    }
}
