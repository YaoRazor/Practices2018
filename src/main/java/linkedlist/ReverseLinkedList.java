package linkedlist;

import datastructures.ListNode;

public class ReverseLinkedList {
        public ListNode reverseList(ListNode head) {
            ListNode pre=null;
            ListNode cur = head;

            while(cur!=null) {

                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }


    public ListNode reverseListRecursive(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
