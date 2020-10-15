package com.lwj.summary;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给定一个数组，找到第K大的数；
 */
public class FindKthLargestProblem {
    public static void main(String[] args) {
        int[] nums = {1,4,2,2,5,3,8,9,10,7};
        mergeSort(nums);
        System.out.print(Arrays.toString(nums));
        /*int k = 3;
        int res1 = findKthLargest(nums, k);
        System.out.println(res1);
        System.out.println("=========================");
        int res2 = findKthLargest1(nums, k);
        System.out.println(res2);
        System.out.println("=========================");

        int res3 = getKth(nums, k);
        System.out.println(res3);*/
    }

    /**
     * 直接暴力排序，然后找到第 K 大的数
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 使用优先级队列实现一个小根堆，堆容量为 K , 取出堆顶元素就是第 K 大的数
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }


    public static int getKth(int[] nums, int k) {
        if (nums == null || k < 1) {
            return 0;
        }
        return findKthLargest3(nums, nums.length - k + 1, 0, nums.length - 1);
    }
    /**
     * 使用快速排序的思想，找到第 k 大的数，在排序的过程中找到结果
     * @param nums
     * @param k
     * @param left
     * @param right
     * @return
     */
    private static int findKthLargest3(int[] nums, int k, int left, int right) {
        if (left >= right) return 0;
        int key = nums[left];
        int start = left, end = right;
        while (true) {
            while (start < end && nums[end] >= key) {
                end--;
            }
            while (start < end && nums[start] < key) {
                start++;
            }
            if (start == end) {
                break;
            }
            swap(nums, start, end);
        }
        swap(nums, start, right);
        if (k == start + 1) {
            return key;
        } else if (k < start + 1) {
            return findKthLargest3(nums, k, left, start - 1);
        } else {
            return findKthLargest3(nums, k, start + 1, right);
        }
    }

    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    static int mpartition(int a[], int l, int r) {
        int pivot = a[l];

        while (l<r) {
            while (l<r && pivot<=a[r]) r--;
            if (l<r) a[l++]=a[r];
            while (l<r && pivot>a[l]) l++;
            if (l<r) a[r--]=a[l];
        }
        a[l]=pivot;
        return l;
    }

    static void quick_sort (int a[], int l, int r) {
        if (l < r) {
            int q = mpartition(a, l, r);
            quick_sort(a, l, q-1);
            quick_sort(a, q+1, r);
        }
    }


    public static void mergeSort(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        merge(nums, 0, len - 1, temp);
    }
    private static void merge(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            merge(nums, left, mid, temp); // 对左边进行分治排序
            merge(nums, mid + 1, right, temp); // 对右边边进行分治排序
            mergeArrays(nums, left, mid, right, temp);
        }
    }

    private static void mergeArrays(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int m = mid, n = right;
        int k = 0;
        while (i <= m && j <= n) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= m) {
            temp[k++] = nums[i++];
        }
        while(j <= n) {
            temp[k++] = nums[j++];
        }
        for (int l = 0; l < k; l++) {
            nums[left + l] = temp[l];
        }
    }
}
