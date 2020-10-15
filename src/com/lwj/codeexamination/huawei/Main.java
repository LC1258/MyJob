package com.lwj.codeexamination.huawei;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> red = new ArrayList<>();
        List<Integer> blue = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int cntRed = 0, cntBlue = 0;
        int maxRed = 0, maxBlue = 0;
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            String[] ss = s.split(" ");
            int x = Integer.parseInt(ss[0]);
            int y = Integer.parseInt(ss[1]);
            if (y == 1) {
                red.add(x);
                cntRed++;
            } else {
                blue.add(x);
                cntBlue++;
            }
            map.put(s, i + 1);
        }
        // 如果红糖果总数和蓝色糖果总数都是小于3的，直接返回
        if (cntBlue < 3 && cntRed < 3) {
            System.out.println("null");
            return;
        }
        // 如果红色糖果总数大于3，那么直接排序，然后取最大的3个
        if (cntRed >= 3) {
            Collections.sort(red);
            for (int i = red.size() - 1; i >= red.size() - 3 ; i--) {
                maxRed += red.get(i);
            }
        }
        // 如果蓝色糖果总数大于3，那么直接排序，然后取最大的3个
        if (cntBlue >= 3) {
            Collections.sort(blue);
            for (int i = blue.size() - 1; i >= blue.size() - 3 ; i--) {
                maxBlue += blue.get(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        int maxColor = 0;
        if (maxRed > maxBlue) {
            for (int i = red.size() - 1; i >= red.size() - 3; i--) {
                res.add(red.get(i));
            }
            maxColor = 1;
        } else {
            for (int i = blue.size() - 1; i >= blue.size() - 3 ; i--) {
                res.add(blue.get(i));
            }
            maxColor = 2;
        }
        Collections.sort(res);
        List<Integer> ans = new ArrayList<>();
        if (maxColor == 1) {
            for (int i = 0; i < res.size(); i++) {
                int temp = res.get(i);
                String key = temp + " " + 1;
                if (map.containsKey(key)) {
                    ans.add(map.get(key));
                }
            }
        } else {
            for (int i = 0; i < res.size(); i++) {
                int temp = res.get(i);
                String key = temp + " " + 2;
                if (map.containsKey(key)) {
                    ans.add(map.get(key));
                }
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            if (i == ans.size() - 1) {
                System.out.print(ans.get(i));
            } else {
                System.out.print(ans.get(i) + " ");
            }
        }
        System.out.println();
        System.out.println(maxColor);
        System.out.println(Math.max(maxBlue, maxRed));
    }
}
