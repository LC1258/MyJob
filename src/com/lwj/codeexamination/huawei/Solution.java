package com.lwj.codeexamination.huawei;

class RandomListNode {
    int label;
    RandomListNode next;
    RandomListNode random;
    public RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        a.random = c;
        RandomListNode res = new Solution().Clone(a);
        System.out.println(res.label);
    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)return null;
        RandomListNode cur = pHead;
        RandomListNode next = cur.next;
        while(cur!=null && next != null){
            RandomListNode clone = new RandomListNode(cur.label);
            cur.next = clone;
            clone.next = next;
            cur = next;
            next = cur.next;
        }
        cur = pHead;
        next = cur.next.next;
        while(cur!=null){
            cur.next.random = cur.random==null?null:cur.random.next;
            cur = next;
            next = cur.next.next;
        }
        cur = pHead;
        RandomListNode head = new RandomListNode(0);
        head.next = cur.next;
        while(cur!=null){
            RandomListNode clone = cur.next;
            cur.next = clone.next;
            clone.next = cur.next==null?null:cur.next.next;
            cur = cur.next;
        }return head.next;
    }
}
