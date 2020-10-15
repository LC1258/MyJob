package com.lwj.summary;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ExamRoom {
    private Map<Integer, int[]> startMap;

    private Map<Integer, int[]> endMap;

    private TreeSet<int[]> pq;

    private int N;
    public ExamRoom(int N) {
        this.N = N;
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        pq = new TreeSet<>((a, b) -> {
           int distA = distance(a);
           int distB = distance(b);
           if (distA == distB) {
               return b[0] - a[0];
           }
           return distA - distB;
        });
        addInterval(new int[]{-1, N});
    }

    private void addInterval(int[] intv) {
        pq.add(intv);
        startMap.put(intv[0], intv);
        endMap.put(intv[1], intv);
    }

    private void removeInterval(int[] intv) {
        pq.remove(intv);
        startMap.remove(intv[0]);
        endMap.remove(intv[1]);
    }

    private int distance(int[] intv) {
        int x = intv[0];
        int y = intv[1];
        if (x == -1) return y;
        if (y == N) return N - 1 - x;
        return (y - x) / 2;
    }
}
