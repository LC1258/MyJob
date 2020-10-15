package com.lwj.summary;

public class FastPow {
    private static final int base = 1337;

    public static void main(String[] args) {
        int a = 2;
        int[] b = {1,2,3};
        int res =  superPow(a, b);
        System.out.println(res);
    }
    public static int superPow(int a, int[] b) {
        return mySuperPow(a, b, b.length - 1);
    }

    public static int fastPow(int a, int k) {
        if (k == 0) return 1;
        a %= base;

        if (k % 2 == 1) {
            return (a * fastPow(a, k - 1)) % base;
        } else {
            int sub = fastPow(a, k / 2);
            return (sub * sub) % base;
        }
    }

    public static int mySuperPow(int a, int[] b, int index) {
        if(index < 0) return 1;
        int last = b[index];

        int part1 = fastPow(a, last);
        int part2 = fastPow(mySuperPow(a, b, index - 1), 10);
        return (part1 * part2) % base;
    }
}
