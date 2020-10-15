package com.lwj.summary;

class ListNode{
    ListNode next;
    ListNode random;
    int val;
    public ListNode(int val) {
        this.val = val;
    }
}

public class ListNodeOperate {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode slow = sortedListToBST(a);
    }

    public static ListNode sortedListToBST(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur= pre;
        while (fast.next != null) {
            fast = fast.next.next;
            cur = cur.next;
            slow = slow.next;
        }
        cur.next = null;
        return slow;
    }

    ListNode  left;

    /**
     * 判断一个单链表是否是一个回文链表
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }
    private boolean traverse(ListNode right) {
        if (right == null) return true;
        boolean res = traverse(right.next);
        // 后序遍历代码
        res = res & (right.val == left.val);
        left = left.next;
        return res;
    }
    /**
     * 逆序输出单链表的值 ,后序遍历
     * @param head
     */
    public void traversePostOrder(ListNode head) {
        if (head == null) return;
        traverse(head.next);
        System.out.println(head.val + " ");
    }

    /**
     * 递归实现 单链表的翻转
     * @param head
     * @return
     */
    public ListNode reverseNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 单链表的翻转，迭代实现
     * @param root
     * @return
     */
    public ListNode reverseNodeWithPartition(ListNode root) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = root;
        nxt = root;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    /**
     * 翻转链表的前 N 个节点
     * @param head
     * @param n
     * @return
     */

    ListNode successor = null; // 当前节点的后继节点
    public ListNode reverseNthNode(ListNode head, int n) {
        if(n == 1) {
            successor = head.next;
            return head;
        }
        // 递归翻转 head.next 的前 n-1 个节点
        ListNode last = reverseNthNode(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * 使用迭代法实现 翻转链表的一部分，(m, n)区间
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) {
            return head;
        }
        ListNode leftNode = new ListNode(0);
        leftNode.next = head;
        ListNode pre = leftNode;
        for(int i=1; i < m; i++) {
            pre = pre.next;
        }

        head = pre.next;
        for(int i=m; i < n; i++) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return leftNode.next;
    }

    public ListNode reverseBetweenWithRecursion(ListNode head, int m, int n) {
        if(m == 1) {
            return reverseNthNode(head, n);
        }
        head.next = reverseBetweenWithRecursion(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 删除链表中的重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    /**
     * 复杂链表的复制
     * @param head
     * @return
     */
    public ListNode copyRandomList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = new ListNode(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            if (temp.random != null) {
                temp.random = cur.random.next;
            }
            cur = temp.next;
        }

        cur = head;
        ListNode res = head.next;
        while (cur.next != null) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            cur = temp;
        }
        return res;
    }


}
