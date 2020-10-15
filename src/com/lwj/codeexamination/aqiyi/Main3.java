package com.lwj.codeexamination.aqiyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        boolean res = isPathCrossing(s);
        if (res == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static boolean isPathCrossing(String s) {
        if (s == null || "".equals(s)) {
            return false;
        }
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();
        set.add("0,0");
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'N' :
                    y++;
                    break;
                case 'S' :
                    y--;
                    break;
                case 'E' :
                    x++;
                    break;
                case 'W' :
                    x--;
                    break;
                default:
                    break;
            }
            if (!set.add(x + "," + y)) {
                return true;
            }
        }
        return false;
    }
}
