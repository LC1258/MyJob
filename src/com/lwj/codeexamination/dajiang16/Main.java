package com.lwj.codeexamination.dajiang16;

import java.util.Scanner;

public class Main {
    public static int MaxValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int vertex = input.nextInt();
        int edge = input.nextInt();

        int[][] matrix = new int[vertex][vertex];
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                matrix[i][j] = MaxValue;
            }
        }
        for (int i = 0; i < edge; i++) {
            int source = input.nextInt();
            int target = input.nextInt();
            int weight = input.nextInt();
            matrix[source][target] = weight;
        }

        int des = input.nextInt();
        int[] res = Dijsktra(matrix, 0);
        System.out.println(res[des]);
    }

    public static int[] Dijsktra(int[][]weight,int start){
        int length = weight.length;
        int[] shortPath = new int[length];
        shortPath[0] = 0;
        int visited[] = new int[length];
        visited[0] = 1;
        for(int count = 1;count<length;count++){
            int k=-1;
            int dmin = Integer.MAX_VALUE;
            for(int i=0;i<length;i++){
                if(visited[i]==0 && weight[start][i]<dmin){
                    dmin = weight[start][i];
                    k=i;
                }
            }
            shortPath[k] = dmin;
            visited[k] = 1;
            for(int i=0;i<length;i++){
                if(visited[i]==0 && weight[start][k]+weight[k][i]<weight[start][i]){
                    weight[start][i] = weight[start][k]+weight[k][i];
                }
            }
        }
        return shortPath;
    }
}