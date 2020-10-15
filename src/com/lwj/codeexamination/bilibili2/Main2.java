package com.lwj.codeexamination.bilibili2;

public class Main2 {
    public int GetMaxConsecutiveOnes (int[] arr, int k) {
        // write code here
        int max = 0;
        int count = 0;
        int left = 0, right = 0;
        while (right < arr.length) {
            if (arr[right] == 0) count++;
            while (count > k) {
                if (arr[left] == 0) count--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
