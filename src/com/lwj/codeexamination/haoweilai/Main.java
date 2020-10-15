package com.lwj.codeexamination.haoweilai;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ListNode{
    ListNode next;
    int val;
    public ListNode(int val) {
        this.val = val;
    }
}

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        String res = preOrderWithIteration(root);
        System.out.println(res);
    }
    /**
     * 使用栈结构实现二叉树的非递归先序遍历，每次先把最左边的节点入栈，
     * 然后出栈更新 root 节点
     * @param root
     */
    public static String preOrderWithIteration(TreeNode root){
        List<Integer> preList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                preList.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < preList.size(); i++) {
            if (i != preList.size() - 1) {
                sb.append(preList.get(i) + ",");
            } else {
                sb.append(preList.get(i));
            }
        }
        return sb.toString();
    }

    // 第二题链表反转
    public ListNode reverseNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
