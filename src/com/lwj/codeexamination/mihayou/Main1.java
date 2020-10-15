package com.lwj.codeexamination.mihayou;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        /*int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = in.nextInt();
            }
        }*/
        int k = Math.max(M, N);
        char[] s = new char[k];
        Arrays.fill(s, '0');

        Set<String> col = new HashSet<>();
        Set<String> input = new HashSet<>();
        for (int i = 0; i < k; i++) {
            s[i] = '1';
            col.add(new String(s));
        }
        List<String> matrix = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String temp = "";
            for (int j = 0; j < N; j++) {
                int num = in.nextInt();
                temp = temp + num;
                if (col.contains(temp)) {
                    input.add(temp);
                }
            }
        }
        if (col.size() == input.size()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
