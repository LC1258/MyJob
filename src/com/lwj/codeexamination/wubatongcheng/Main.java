package com.lwj.codeexamination.wubatongcheng;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    }
    public ArrayList<String> findCommonString (ArrayList<ArrayList<String>> values) {
        // write code here
        int n = values.size();
        ArrayList<String> res = new ArrayList<>();
        if (n <= 0) return res;
        if (n == 1) return values.get(0);
        res  = help(values.get(0), values.get(1));
        for (int i = 2; i < n; i++) {
            res = help(res, values.get(i));
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            if (!ans.contains(res.get(i))) {
                ans.add(res.get(i));
            }
        }
        return ans;
    }
    public ArrayList<String> help(ArrayList<String> l1, ArrayList<String> l2) {
        ArrayList<String> res = new ArrayList<>();
        for (String s : l1) {
            if (l2.contains(s)) {
                res.add(s);
            }
        }
        return res;
    }

    /*public int question (int a, int b) {
        // write code here
        int res = 0;
        for (int i = 0; i <= 500; i++) {
            int x = i + a;
            int y = i + b;
            if (isCompSqrt(x) && isCompSqrt(y)) {
                res = i;
            }
        }
        return res;
    }

    private boolean isCompSqrt(long num) {
        double f = Math.sqrt(num);
        long q = (long)f;
        if (num == q * q) {
            return true;
        }
        return false;
    }*/
}
