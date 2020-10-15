package com.lwj.codeexamination.bilibili2;

import java.util.ArrayList;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        int n = 3;
        String res = printZ(n);
        System.out.println(res);
    }

        public static String printZ(int num) {
            if (num % 2 == 0) {
                return "";
            }
            int n = num / 2  + 1;
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) // 输出菱形的zhi上半部分
            {
                StringBuilder temp = new StringBuilder();
                for (int j = 1; j <= n - i; j++)
                    temp.append("*");
                for (int k = 1; k <= i; k++)
                    temp.append(k);
                for (int m = i - 1; m > 0; m--)
                    temp.append(m);
                while (temp.length() < num) {
                    temp.append("*");
                }
                list.add(temp.toString());
                System.out.println(temp.toString());
            }
            for (int i = n - 1; i > 0; i--) // 输出菱形的下半部分
            {
                StringBuilder temp = new StringBuilder();
                for (int j = 1; j <= n - i; j++)
                    temp.append("*");
                for (int k = 1; k <= i; k++)
                    temp.append("" + k);
                for (int m = i - 1; m > 0; m--)
                    temp.append("" + m);
                while (temp.length() < num) {
                    temp.append("*");
                }
                list.add(temp.toString());
                System.out.println(temp.toString());
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i != list.size() - 1) {
                    sb.append(list.get(i)).append("|");
                } else {
                    sb.append(list.get(i));
                }
            }
            return sb.toString();
        }

}
