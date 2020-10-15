package com.lwj.summary;

import java.util.LinkedList;

/**
 * 假设盘⼦上有 n 块⾯积⼤⼩不⼀的烧
 * 饼， 你如何⽤⼀把锅铲进⾏若⼲次翻转， 让这些烧饼的⼤⼩有序
 * 使用递归实现
 * 时间复杂度为 O(n^2)
 */
public class PanCakeSort {

    LinkedList<Integer> res = new LinkedList<>();

    private LinkedList<Integer> panCakeSort(int[] cakes) {
        sort(cakes, cakes.length);
        return res;
    }
    private void sort(int[] cakes, int n) {
        // base case
        if (n == 1) {
            return;
        }

        // 寻找最大烧饼索引
        int maxCake = 0;
        int maxCakeIndex = 0;
        for(int i=0; i < n; i++) {
            if(cakes[i] > maxCake) {
                maxCake = cakes[i];
                maxCakeIndex = i;
            }
        }

        // 第一次翻转，将最大的烧饼放到最上面
        reverse(cakes, 0, maxCakeIndex);
        res.add(maxCakeIndex + 1);
        // 第二次翻转， 将最大的烧饼放到最下面
        reverse(cakes, 0, n - 1);
        res.add(n);

        // 递归调用
        sort(cakes, n - 1);
    }
    private void reverse(int[] arr, int i, int j) {
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
