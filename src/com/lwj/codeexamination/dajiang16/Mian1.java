package com.lwj.codeexamination.dajiang16;

import java.util.Scanner;

public class Mian1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int capacity = in.nextInt();
        int[] weight = new int[N+1];
        int[] value = new int[N+1];
        weight[0] = 0;
        value[0] = 0;
        in.nextLine();
        for (int i = 1; i <= N; i++) {
            value[i] = in.nextInt();
            weight[i] = in.nextInt();
        }
        int res = getBiggestValue(weight, value, capacity);
        System.out.println(res);
    }

    public static int getBiggestValue(int[] weight,int[] value,int capacity){
        int[] f = new int[capacity+1];
        for(int i=0;i < weight.length;i++){
            for(int j = capacity;j>=0;j--){
                if(j >= weight[i]){
                    f[j] = Math.max(f[j-weight[i]] + value[i], f[j]);
                }
            }
        }
        return f[capacity];
    }
}
