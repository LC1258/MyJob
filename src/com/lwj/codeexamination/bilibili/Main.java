package com.lwj.codeexamination.bilibili;

public class Main {
    public int getCount(int len, int m, int n) {
        int i = 1;
        while ((m - n) * i + m < len) {
            i++;
        }
        return i;
    }
}
