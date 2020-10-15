package com.lwj.codeexamination.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != k) {
                list.add(nums[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print(list.get(i) + " ");
            } else {
                System.out.print(list.get(i));
            }
        }
        ListNode head = buildList(nums);
        ListNode res = removeKthNode(head,  n - k + 1);
        while(res.next != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.print(res.val);
    }

    private static ListNode buildList(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        int len = nums.length;
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < len; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    private static ListNode removeKthNode(ListNode head, int k) {
        if (head == null || k < 1) {
            return head;
        }
        ListNode temp = head;
        int num = 0;
        while (temp != null) {
            num++;
            temp = temp.next;
        }
        if (num == k) {
            return head.next;
        }
        if (num > k) {
            temp = head;
            while (num - k != 1) {
                temp = temp.next;
                num--;
            }
            temp.next = temp.next.next;
        }
        return head;
    }
}
