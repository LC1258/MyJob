package com.lwj.codeexamination.netease;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String A = in.nextLine();
        String B = in.nextLine();
        String res = getMinB(A, B, n);
        System.out.println(res);
    }
    static List<String> res = new ArrayList<>();
    private static String getMinB(String A, String nums, int n) {
        int len = n;
        boolean[] visited = new boolean[len];
        StringBuilder sb = new StringBuilder();
        char[] chars = nums.toCharArray();
        if (chars.length != n) {
            return "-1";
        }
        Arrays.sort(chars);
        dfs(A, sb, chars, visited);
        Collections.sort(res);
        System.out.println(res);
        for (int i = 0; i < res.size(); i++) {
            String cur = res.get(i);
            if (cur.compareTo(A) == 1) {
                return cur;
            }
        }
        return "-1";
    }
    private static void dfs(String A, StringBuilder sb, char[] chars, boolean[] visited) {
        if (sb.length() == chars.length) {
            if (sb.toString().compareTo(A)  == 1) {
                res.add(sb.toString());
                return;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i] == chars[i - 1]) {
                if (visited[i - 1] == true);
                else  continue;
            }
            if (visited[i] == true) continue;
            visited[i] = true;
            sb.append(chars[i]);
            dfs(A, sb, chars, visited);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static String getMinMax(String A, String B, int n) {
        int lenB = B.length();
        int lenA = A.length();

        if (lenB != n || lenA != lenB) return "-1";

        char[] chars = B.toCharArray();
        for (int i = 0; i < lenB - 1; i++) {
            for (int j = 0; j < lenB - 1 - i; j++) {
                if (chars[j] > chars[j + 1]) {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
            String cur = new String(chars);
            System.out.println(Arrays.toString(chars));
            /*if (cur.compareTo(A) == 1) {
                return cur;
            }*/
        }
        System.out.println(Arrays.toString(chars));
        return "-1";
    }
}
