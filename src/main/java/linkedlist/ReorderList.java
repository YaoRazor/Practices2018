package linkedlist;

import datastructures.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverseList(head2);


        merge(head1, head2);

    }

    private void merge(ListNode left, ListNode right) {
        while(left!=null && right!=null) {
            ListNode tmp = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = tmp;
        }

    }


    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        while(cur!=null) {

            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;

        }

        return pre;
    }
}
