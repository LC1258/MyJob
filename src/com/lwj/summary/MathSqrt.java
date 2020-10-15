package com.lwj.summary;

import java.math.BigDecimal;

public class MathSqrt {
    public static void main(String[] args) {
        double res1 = Math.sqrt(2);
        System.out.println(res1);
        double res = MathSquare(2, 8);
        System.out.println(res);
    }

    /**
     *  实现整数开方运算
     * @param n     需要开根号的数
     * @param m     需要保留的小数位数，精度
     * @return
     */
    public static double MathSquare(int n, int m) {
        double[] arr = new double[m];
        if (m > 0) {
            arr = sc(m);
        }
        int s = sq(n);
        return sb(n, s, arr);
    }

    /**
     * 计算 n 开方的整数位
     * @param n
     * @return
     */
    private static int sq(int n) {
        if (n == 1) return 1;
        int temp = 0;
        for (int i = 1; i <= n / 2 + 1; i++) {
            if (i * i == n) {
                temp = i;
                break;
            }
            if (i * i > n) {
                temp = i - 1;
                break;
            }
        }
        return temp;
    }

    /**
     * 计算要保留的小数位
     * @param m
     * @return
     */
    private static double[] sc(int m) {
        double[] res = new double[m];
        int num = 0;
        while (num != m) {
            double f = 1.0;
            for (int i = 0; i <= num; i++) {
                f = f * 10;
            }
            res[num] = 1 / f;
            num++;
        }
        return res;
    }

    /**
     * 开根号
     * @param n
     * @param j
     * @param arr
     * @return
     */
    private static double sb(int n, double j, double[] arr) {
        double temp = j;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                j = temp; //计算过后的值（整数位+小数位的和，赋值给j，下面继续运算）
            }
            for (int k = 1; k <= 9; k++) { //小数位只有九位{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9}
                temp = k * arr[i] + j;       //i*arr[p],相当于每次加0.1,0.2 ...
                if (temp * temp == n) {
                    return temp;
                }
                if (temp * temp > n) {  //避免丢失精度
                    BigDecimal c1 = new BigDecimal(Double.toString(temp));
                    BigDecimal c2 = new BigDecimal(Double.toString(arr[i]));
                    temp = c1.subtract(c2).doubleValue();
                    break;
                }
            }
        }
        return temp;
    }
}
