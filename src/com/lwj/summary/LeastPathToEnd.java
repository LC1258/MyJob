package com.lwj.summary;

public class LeastPathToEnd {

    public static void main(String[] args) {

        int[][] grids = {
                {0,0,0,0,0,0,0,0},
                {-1,0,-1,0,0,0,-1,0},
                {0,0,0,0,-1,0,0,0},
                {-1,0,-1,0,0,-1,0,0},
                {0,0,-1,0,0,0,0,0},
                {0,0,0,-1,-1,0,-1,0},
                {0,-1,0,0,0,-1,-1,-1},
                {0,0,0,0,0,0,-1,0}};
        int res = leastPathToEnd(grids);
        System.out.println(res);
    }

    private static final int MAXVALUE = 100000;
    public static int leastPathToEnd(int[][] grids) {
        int row = grids.length;
        int col = grids[0].length;
        for (int i = row - 2; i >= 0; i--) {
            if (grids[i + 1][col - 1] != -1) {
                grids[i][col - 1] = 1 + grids[i + 1][col - 1];
            } else {
                grids[i][col - 1] = MAXVALUE;
            }
        }
        for (int i = col - 2; i >= 0; i--) {
            if (grids[row - 1][i + 1] != -1) {
                grids[row - 1][i] = 1 + grids[row - 1][i + 1];
            } else {
                grids[row - 1][i] = MAXVALUE;
            }
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                if (grids[i][j] == -1) {
                    grids[i][j] = MAXVALUE;
                    continue;
                }
                grids[i][j] = 1 + Math.min(grids[i + 1][j], grids[i][j+1]);
            }
        }
        return grids[0][0] >= MAXVALUE ? -1 : grids[0][0];
    }
}
