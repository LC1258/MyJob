package com.lwj.codeexamination.zuiyou;

import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {
        /*int[][] increase = {{2,8,4}, {2,5,0}, {10, 9, 8}};
        int[][] requirements = {{2,11,3}, {15,10,7}, {9,17,12}, {8,1,14}};*/
        int[][] increase = {{1, 1, 1}};
        int[][] requirements = {{0, 0, 0}};
        int[] res = getTriggerTime(increase, requirements);

        System.out.println(Arrays.toString(res));
    }

    public static int[] getTriggerTime (int[][] increase, int[][] requirements) {
        // write code here

        int days = increase.length;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int[][] preSum = new int[days + 1][3];
        preSum[0] = new int[]{sum1, sum2, sum3};
        for (int i = 1; i <= days; i++) {
            sum1 += increase[i - 1][0];
            sum2 += increase[i - 1][1];
            sum3 += increase[i - 1][2];
            preSum[i] = new int[]{sum1, sum2, sum3};
        }
        int[] res = new int[requirements.length];
        for (int i = 0; i < requirements.length; i++) {
            for (int j = 0; j <= days; j++) {
                if (requirements[i][0] <= preSum[j][0] && requirements[i][1] <= preSum[j][1] && requirements[i][2] <= preSum[j][2]) {
                    res[i] = j;
                    break;
                } else {
                    res[i] = -1;
                }
            }
        }
        return res;
    }
}
