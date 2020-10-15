package com.lwj.summary;

public class SolveSudoku {
    public void solveSudoku(char[] board) {
        StringBuilder sb = new StringBuilder();
    }

    public boolean backTrace(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if(j == n) {
            // 穷举到最后一列的话直接换到下一行
            return backTrace(board, i + 1, 0);
        }
        if(i == m) {
            // 找到一个可行解，触发base case
            return true;
        }

        if(board[i][j] != '.') {
            // 如果已经存在数字了，直接遍历下一个
            return backTrace(board, i, j+1);
        }

        for(char ch = '1'; ch <= '9'; ch++) {
            if(!isValid(board, i, j, ch)) {
                continue;
            }
            board[i][j] = ch;
            if(backTrace(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }
        return false;
    }

    /**
     * 判断 将字符 n 放在 board[i][j] 是否是一个合法的操作
     * @param board
     * @param r
     * @param c
     * @param n
     * @return
     */
    private static boolean isValid(char[][] board, int r, int c, char n) {
        for (int i=0; i < 9; i++) {
            // 判断行是否存在重复
            if (board[r][i] == n) return false;
            // 判断列是否存在重复
            if (board[i][c] == n) return false;
            // 判断3 × 3 是否存在重复
            if(board[(r/3)*3 + i / 3][(c/3)*3 + i%3] == n) return false;
        }
        return true;
    }
}
