package com.lwj.codeexamination.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (in.hasNext()) {
            String temp = in.nextLine();
            list.add(temp);
            if (temp.length() == 1) {
                break;
            }
        }
        String s = in.nextLine();
        list.add(s);
        in.close();
        /*int len = list.size();
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            res.add(list.get(i));
        }
        int num = Integer.parseInt(list.get(len - 2));
        String last = list.get(len - 1);
        String target = feat(last, num);
        ArrayList<String> ans = new ArrayList<>()
        for (int i = 0; i < ; i++) {

        }*/
    }
}
