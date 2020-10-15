package com.lwj.codeexamination.netease;

import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        String res = compress("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBeeeeeeeeeeFYHHnjHAPQQc");
        System.out.println(res.equals("0ZB0tB0geFYHHnjHAPQQc"));
        System.out.println(res);
    }
    public static String compress (String raw_str) {
        // write code here
        Map<Integer, Character> map = new HashMap<>();
        int k = 4;
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(k, i);
            k++;
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(k, i);
            k++;
        }
        int N = raw_str.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < N) {
            int j = i;
            while (j < N && raw_str.charAt(j) == raw_str.charAt(i)) {
                j++;
            }
            int cutLen = j - i;
            if (cutLen >= 4 && cutLen <= 55) {
                char ch = raw_str.charAt(i);
                String temp = "0" + map.get(j - i) + ch;
                sb.append(temp);
            } else if (cutLen < 4) {
                for (int l = 0; l < j - i; l++) {
                    char ch = raw_str.charAt(i);
                    sb.append(ch);
                }
            } else {
                int mod = cutLen % 55;
                int total = cutLen / 55;
                while (total-- > 0) {
                    char ch = raw_str.charAt(i);
                    String temp = "0" + map.get(55) + ch;
                    sb.append(temp);
                }
                if (mod >= 4) {
                    char ch = raw_str.charAt(i);
                    String temp = "0" + map.get(mod) + ch;
                    sb.append(temp);
                } else {
                    for (int l = 0; l < mod; l++) {
                        char ch = raw_str.charAt(i);
                        sb.append(ch);
                    }
                }
            }
             i = j;
        }
        return sb.toString();
    }
}
