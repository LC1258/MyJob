package com.lwj.codeexamination.zuiyou;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        long res = getNum(s);
        System.out.println(res);
    }

    private static long getNum(String s) {
        String ss = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char ch = s.charAt(0);
        if (ch == '-') {
            s = s.substring(1);
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ss.length(); i++) {
            map.put(ss.charAt(i), i);
        }
        int size = s.length();
        long num = 0;
        for (int i = 0; i < size; i++) {
            String str = String.valueOf(s.charAt(i)).toUpperCase();
            if (!ss.contains(str)) {
                return 0;
            }
            num = (long) (map.get(str.charAt(0)) * Math.pow(36, size - i - 1) + num);
        }
        return ch == '-' ? -1 * num : num;
    }
}
