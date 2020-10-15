package com.lwj.summary;

public class TraverseMatrix {
    public static void main(String[] args) {
        int[][] matrix=new int[][]{
                {4,5,8,6,9},
                {7,9,3,5,8},
                {3,5,1,1,4},
                {5,8,7,4,9},
                {1,4,7,8,9}
        };
        new TraverseMatrix().traverse(matrix);
    }

    public void traverse(int[][] matrix) {
        System.out.println("输出该矩阵为:");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("===============================");
        System.out.println("打印左下三角 :包含对角线");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("打印左下三角 :不包含对角线");
        for(int i = 1; i < matrix.length; i++){//去掉首行且去掉对角线上（相当于等号）
            for(int j = 0; j < i; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("===============================");
        /**
         * 是数组或矩阵，则需要循环空格，
         * 若是遍历各位置上的元素进行赋值或者判断时，不用循环空格
         * 注意：数组下标越界问题
         */
        System.out.println("打印右上三角 :包含对角线");
        for(int i=0;i<matrix.length;i++){
            for(int k=0;k<i;k++){
                System.out.print("  ");
            }
            for(int j=i;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("打印右上三角 :不包含对角线");
        for(int i = 0; i < matrix.length - 1; i++){//行数减一
            for(int k = 0; k < i; k++){
                System.out.print("  ");
            }
            for(int j = i + 1; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("===============================");
        // 打印左上三角
        System.out.println("打印左上三角");
        for(int i = 0; i < matrix.length; i++){//行数减一

            for(int j=0;j < matrix[i].length - i;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("打印右下三角");
        for (int i = 0; i < matrix.length; i++) {
            for(int k = 0; k < matrix.length - i - 1; k++){
                System.out.print("  ");
            }
            for (int j = matrix[0].length - i - 1; j <= matrix[0].length - 1 ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
