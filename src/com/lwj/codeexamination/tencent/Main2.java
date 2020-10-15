package com.lwj.codeexamination.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    static char[] s = new char[100005];
    static int[] q = new int[100005];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = in.nextInt();
        int i = 0;
        int len = s.length();
        int head = 0;
        int rear = -1;
        for (i = 0; i < len - n; i++) {
            while (head <= rear && s.charAt(q[rear]) > s.charAt(i)){
                rear--;
            }
            q[++rear] = i;
        }
        for (; i < len; i++) {
            while (head <= rear && s.charAt(q[rear]) > s.charAt(i)){
                rear--;
            }
            q[++rear] = i;
            System.out.print(s.charAt(q[head++]));
        }
        /*List<String> res = subSets(s.toCharArray());
        Collections.sort(res);
        System.out.println(res.get(n));*/
    }
    private static List<String> res = new ArrayList<>();

    public static List<String> subSets(char[] nums) {
        List<String> trace = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrace(nums, 0, sb);
        return res;
    }
    private static void backTrace(char[] nums, int start,StringBuilder sb) {
        if (res.contains(sb.toString())) {
            return;
        }
        res.add(sb.toString());
        for(int i = start; i < nums.length; i++) {
            sb.append(nums[i]);
            backTrace(nums, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    
}
