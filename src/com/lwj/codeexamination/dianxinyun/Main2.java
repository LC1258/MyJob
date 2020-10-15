package com.lwj.codeexamination.dianxinyun;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int capacity = in.nextInt();
        int N = in.nextInt();
        double[] weight = new double[N+1];
        int[] value = new int[N+1];
        weight[0] = 0;
        value[0] = 0;
        in.nextLine();
        for(int i = 1; i<= N;i++) {
            String str = in.nextLine();
            String[] strs = str.split(" ");
            weight[i] = Double.valueOf(strs[0]);
            value[i] = Integer.valueOf(strs[1]);
        }
        int res = (int) getBiggestValue(weight, value, capacity);
        System.out.println(res);
    }

    public static double getBiggestValue(double[] weight,int[] value,int capacity){
        double[] f = new double[capacity+1];
        for(int i=0;i < weight.length;i++){
            for(int j = capacity;j>=0;j--){
                if(j >= weight[i]){
                    f[j] = Math.max((f[j-(int)weight[i]]) + value[i], f[j]);
                }
            }
        }
        return f[capacity];
    }
}
