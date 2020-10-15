package com.lwj.codeexamination.sougou;

public class Main2 {
    public static void main(String[] args) {
        int t = 2;
        int[] xa = {-1, 4, 5, 2};
        int res = getHouses(t, xa);
        System.out.println(res);
    }

    public static int getHouses (int t, int[] xa) {
        // write code here
        int count = 0;
        int len = xa.length;
        if (len == 1) {
            return 1;
        }
        for (int i = 0; i < len - 3; i++) {
            int center1 = xa[i];
            int width1 = xa[i + 1];
            int nextCenter = xa[i + 2];
            int nextWidth = xa[i + 3];
            int length = nextCenter - center1;
            double diff = length - width1 / 2.0 - nextWidth / 2.0;
            if (t <= diff) {
                count += 2;
            }
        }
        count += 2;
        return count;
    }
}
