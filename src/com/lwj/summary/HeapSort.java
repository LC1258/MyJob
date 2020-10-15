package com.lwj.summary;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {2,1, 3,4,9,5,8,5,6};
        new HeapSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }
    private void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int k = i * 2 + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && nums[k] < nums[k+1]) {
                k++;
            }
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
