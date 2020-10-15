package com.lwj.codeexamination.huaweiinterview;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split(" ");
        int length = inputLine.length;
        long[] inputNums = new long[length];
        for (int i = 0; i < length; i++) {
            inputNums[i] = Long.parseLong(inputLine[i]);
        }
        long bits1 = 0x55555555L, bits2 = 0xAAAAAAAAL, bits3 = 0xFFFFFFFFL;
        long twoBits = 0L;
        for (int i = 0; i < length; i++) {
            inputNums[i] = (((inputNums[i] & bits1) << 1) | ((inputNums[i] & bits2) >> 1)) & bits3;

            inputNums[i] = inputNums[i] | (twoBits << 32);
            twoBits = inputNums[i] & 0x3L;
            inputNums[i] >>= 2;
        }
        inputNums[0] = inputNums[0] | (twoBits << 30);

        for (int i = 0; i < length - 1; i++)
            System.out.print("" + inputNums[i] + " ");
        System.out.println(inputNums[length - 1]);
    }
    /*public void getDay(int n) {
        if (n == 0) {

        }
        int totalYear = n / 360;
        int days = n % 360;
        int month = days / 30;
        int monDays = days % 30;
        int today_year = totalYear + 2000;
        int today_month = 1 + month;
        int today_day = 1 + monDays;
        System.out.println(today_year + ":" + today_month + ":" + today_day);
    }*/

    /*class CalculateDate{
        private int day = 1;
        private int month = 1;
        private int year = 2000;

        public CalculateDate next(CalculateDate date) {
            if (date.day == isLastDays(date.year, date.day)) {
                date.day = 1;
                date.month++;
                if (date.month == 13) {
                    date.year++;
                    date.month = 1;
                }
            }
            return
        }
        public int isLastDays(int year, int month) {
            if (month == 2) {
                return 28;
            } else if (month == 4 || month == 6 || month == 9 || month == 11){
                return 30;
            } else {
                return 31;
            }
        }*/

}
