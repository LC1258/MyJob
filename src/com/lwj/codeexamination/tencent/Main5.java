package com.lwj.codeexamination.tencent;

public class Main5 {

    public static int[] longestMoutain(int[] nums) {
        int[] lisLength=new int[nums.length];//用于记录当前个元素作为最大元素的最长递增序列的长度

        for (int i = 0; i < nums.length; i++) { //初始化
            lisLength[i]=1;
        }

        int max=1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <i; j++) {

                if (nums[j]<nums[i]&&(lisLength[j]+1)>lisLength[i]) {
                    lisLength[i]=lisLength[j]+1;
                }

                if (max<lisLength[i]) { //得到当前最长递增序列的长度以及该子序列的最末元素的位置
                    max=lisLength[i];
                }
            }

        }
        return lisLength;
    }
    public static void commonOfTwoArrs(int [] a,int [] b) {
        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j])
                j++;
            else if (a[i] > b[j])
                i++;
            else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }
    }
        public static void main(String[] args) {
        int[] nums = {3,0,2,1,2,3};
        int[] a = {5,4,3,2,1};
        int[] b = {6,5,4,3,2,1};

       commonOfTwoArrs(a, b);
    }
}
