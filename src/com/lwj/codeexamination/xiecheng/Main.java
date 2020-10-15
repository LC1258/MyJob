package com.lwj.codeexamination.xiecheng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String words = in.nextLine();
        String key = in.nextLine();
        ArrayList<String> res = Permutation(str);
        System.out.println(res);
        int len = str.length();
        char[] chs = words.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < words.length() - len; ) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                sb.append(chs[i + j]);
            }
            if (res.contains(sb.toString())) {
                ans.append(key);
                i = i + key.length();
            }
            ans.append(chs[i]);
            i++;
        }
        System.out.println(ans.toString());
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList list = new ArrayList();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, list);
            //上图所示，左右在以C开头的字符串，结果并不是已经排好序的，所以进行sort
            Collections.sort(list);
        }
        return list;
    }

    //递归method
    public static void PermutationHelper(char[] cs, int i, ArrayList list) {
        //当进行两次交换即：A swap A ， B swap B
        if (i == cs.length - 1) {
            //结果之一
            String val = String.valueOf(cs);
            //这里做了去重判断，原因是因为当有重复的元素时会出现相同的字符串，例：aabc
            if (!list.contains(val)) {
                list.add(val);
            }
        } else {
            for (int j = i; j < cs.length; ++j) {
                swap(cs, i, j);
                PermutationHelper(cs, i + 1, list);
                //回溯
                swap(cs, i, j);
            }
        }
    }

    //swap交换操作
    public static void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}

