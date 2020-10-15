package com.lwj.summary;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public static void main(String[] args) {
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for(char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int maxLen = Integer.MAX_VALUE;
        int start = 0;

        int match = 0; // 表示 needs 中的字符和 windows中的字符匹配的次数
        while(right < s.length()) {
            char ch = s.charAt(right);
            if(needs.containsKey(ch)) {
                windows.put(ch, windows.getOrDefault(ch, 0) + 1);
                if(windows.get(ch) == needs.get(ch)) {
                    match++;
                }
            }
            // 窗口增大
            right++;
            while(match == needs.size()) {
                if (right - left > maxLen) {
                    start = left;
                    maxLen = right - left;
                }
                char temp = s.charAt(left);
                if(needs.containsKey(temp)) {
                    windows.put(temp, windows.getOrDefault(temp, 0) - 1);
                    if(windows.get(temp) < needs.get(temp)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return maxLen == Integer.MAX_VALUE ? "" : s.substring(start, start + maxLen);
    }
}
