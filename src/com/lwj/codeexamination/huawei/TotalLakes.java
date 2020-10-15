package com.lwj.codeexamination.huawei;

import java.util.ArrayList;
import java.util.List;

public class TotalLakes {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(1);
        char[][] board = {
                {'S', 'S', 'H', 'H', 'H'},
                {'S', 'S', 'H', 'H', 'H'},
                {'H', 'H', 'S', 'S', 'H'},
                {'H', 'H', 'H', 'S', 'S'}
        };
        int res = new TotalLakes().getTotalLakes(board);
        System.out.println(res);
    }

    public int getTotalLakes(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'S') {
                    count++;
                    dfs(board, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] board, int r, int c) {
        int row = board.length;
        int col = board[0].length;
        if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] == 'H') {
            return;
        }
        board[r][c] = 'H';
        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
        dfs(board, r, c + 1);
    }
}
