package com.lwj.codeexamination.dajiang16;

import java.util.LinkedList;

public class Main3 {
    public static void main(String[] args) {
        String s = "71245323308";
        int k = 4;
        String res = remove(s, k);
        System.out.println(res);
    }
    private static String remove(String num, int k) {
        if (num == null || k >= num.length()) return "0";
        LinkedList<Character> stack = new LinkedList<>();
        int rmNum = 0;
        int index = 0;
        for (; index < num.length(); index++) {
            char c = num.charAt(index);
            while (!stack.isEmpty() && stack.peek() > c && rmNum < k) {
                stack.pop();
                rmNum++;
            }
            if (rmNum >= k) break;
            if (c != '0') stack.push(c);
        }
        while (rmNum < k) {
            stack.pop();
            rmNum++;
        }
        String result = "";
        while (!stack.isEmpty()) result = stack.pop() + result;
        while(result.length() == 0 && index < num.length() && num.charAt(index) == '0') index++;
        if (index < num.length()) result += num.substring(index);

        if (result.length() == 0) return "0";
        return result;
    }
}
