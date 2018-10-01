package linkedlist;

import datastructures.ListNode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || k==0) {
            return head;
        }

        int n = 1;

        ListNode cur = head;

        while (cur.next!=null) {
            n++;
            cur = cur.next;
        }

        ListNode tail = cur;

        int rotate = n-k%n;

        ListNode pre = null;
        cur = head;

        while (rotate>0) {
            pre = cur;
            cur = cur.next;
        }

        if(pre!=null) {
            pre.next = null;
        }

        tail.next = head;

        return cur;

    }
}
