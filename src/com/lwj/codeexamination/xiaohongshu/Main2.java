package com.lwj.codeexamination.xiaohongshu;

public class Main2 {
    public static void main(String[] args) {
        int[][] arr = {{3,1,4},
                {5, 2, 6}};
        int res = findMin(arr);
        System.out.println(res);
    }

    static int findMin(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        if (row == 0) return 0;
        int n = row * col;
        int[] nums = new int[n];
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                nums[k++] = arr[i][j];
            }
        }
        int left = 0, right = n;
        while (left < right) {
            if (nums[left] == left + 1) {
                left++;
            } else if (nums[left] <= left || nums[left] > right || nums[nums[left] - 1] == nums[left]) {
                right--;
                nums[left] = nums[right];
            } else {
                swap(nums, left, nums[left] - 1);
            }
        }
        return left + 1;
    }
    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
