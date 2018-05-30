package linkedlist;

import datastructures.ListNode;

/**
 * Created by yawang on 5/20/18.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        int i=0;
        while (i<n) {
            fast = fast.next;
            i++;
        }

        while (fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;

    }
}
