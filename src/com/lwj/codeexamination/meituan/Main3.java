package com.lwj.codeexamination.meituan;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[][] profits = new int[n][2];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            String[] strs = str.split(" ");
            profits[i][0] = Integer.parseInt(strs[0]);
            profits[i][1] = Integer.parseInt(strs[1]);
        }

        int res_a = getMax(profits, a, b);
        int res_b = getMax(profits, b, a);
        int max = Math.max(res_a, res_b);
        System.out.println(max);
    }

    private static int getMax(int[][] nums,int a, int b) {
        PriorityQueue<int[]> aMax = new PriorityQueue<>((o1, o2) -> (o2[0] - o1[0]));
        PriorityQueue<int[]> bMax = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        Arrays.sort(nums, (o1, o2) -> (o1[0] - o2[0]));
        for (int i = 0; i < nums.length; i++) {
            aMax.add(nums[i]);
        }
        int aCount = 0;
        for (int i = 0; i < a; i++) {
            aCount += aMax.poll()[0];
        }
        Arrays.sort(nums, (o1, o2) -> (o1[0] - o2[0]));
        for (int i = 0; i < nums.length; i++) {
            if (aMax.contains(nums[i])) {
                bMax.add(nums[i]);
            }
        }
        for (int i = 0; i < b; i++) {
            aCount += bMax.poll()[1];
        }
        return aCount;
    }
}
