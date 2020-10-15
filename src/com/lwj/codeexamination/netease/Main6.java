package com.lwj.codeexamination.netease;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        String s3 = in.nextLine();
        List<String> list11 = Arrays.asList(s1.split(" "));
        List<String> list1 = new ArrayList<>(list11);
        List<String> list22 = Arrays.asList(s1.split(" "));
        List<String> list2 = new ArrayList<>(list22);
        List<String> list33 = Arrays.asList(s3.split(" "));
        List<String> list3 = new ArrayList<>(list33);
        System.out.println(list3);
        list3.removeAll(list1);
        /*for (String s : list1) {
            if (list3.contains(s)) {
                list3.remove(s);
            }
        }*/
        System.out.println(list3);
        int res = getMinOperate(list2, list3);
        System.out.println(res);
    }
    private static int getMinOperate(List<String> l1, List<String> l2) {
        int len1 = l1.size();
        int len2 = l2.size();
        if (len1 == 0) return  len2;
        if (len2 == 0) return  len1;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (l1.get(i - 1).equals(l2.get(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[len1][len2];
    }
}
