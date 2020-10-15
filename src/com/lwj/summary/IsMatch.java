package com.lwj.summary;

import java.util.HashMap;
import java.util.Map;

public class IsMatch {
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        boolean res = new IsMatch().isMatch(s, p);
        System.out.println(res);
    }

    private boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }

    private boolean dp(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }
        Map<String, Boolean> map = new HashMap<>();
        String key = i + "," + j;
        if (map.containsKey(key)) return map.get(key);
        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2);
            } else {
                res = false;
            }
        }
        map.put(key, res);
        return res;
    }
}
