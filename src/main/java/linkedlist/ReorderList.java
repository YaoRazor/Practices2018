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

        ListNode second = slow.next;
        slow.next = null;
        second = reverse(second);

        ListNode first = head;

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        int i = 0;

        while(first!=null && second!=null) {

            if(i%2==0) {
                cur.next = first;
                first = first.next;
            } else {
                cur.next = second;
                second = second.next;
            }

            i++;
            cur = cur.next;
        }

        cur.next = first!=null? first:second;
        return;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while(cur!=null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
