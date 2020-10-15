package com.lwj.summary;

public class PrintMatrix {
    public static void printMatrixZigZag(int[][] matrix) {
        int aX = 0;
        int aY = 0;
        int bX = 0;
        int bY = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        boolean fromUp = false;
        while (aX != endRow + 1) {
            printLevel(matrix, aX, aY, bX, bY, fromUp);
            aX = aY == endCol ? aX + 1 : aX;
            aY = aY == endCol ? aY : aY + 1;
            bY = bX == endRow ? bY + 1 : bY;
            bX = bX == endRow ? bX : bX + 1;
            fromUp = !fromUp;
        }
    }

    private static void printLevel(int[][] m, int aX, int aY, int bX, int bY, boolean f) {
        if (f) {
            // 从上往下打印
            while (aX != bX + 1) {
                System.out.print(m[aX++][aY--] + " ");
            }
        } else {
            // 从下往上打印
            while (bX != aX - 1) {
                System.out.print(m[bX--][bY++] + " ");
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);
    }
}
