package com.lwj.codeexamination.leetcodeZhousai;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 1}, {1, 0}, {-1, 1}};
        int[][] weights = getMatrix(points);
        for (int i = 0; i < weights.length; i++) {
            System.out.println(Arrays.toString(weights[i]));
        }
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j < weights[i].length; j++) {
                min = Math.min(min, weights[i][j]);
            }
            if (i + 1 < weights.length) {
                sum += min;
            }
        }
        System.out.println(sum);
    }

   /*public int minCostConnectPoints(int[][] points) {
        
    }*/
    
    private static int[][] getMatrix(int[][] points) {
        int n = points.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = getDistance(points[i], points[j]);
            }
        }
        return res;
    }
    private static int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}