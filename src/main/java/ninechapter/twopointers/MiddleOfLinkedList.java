package ninechapter.twopointers;

import datastructures.ListNode;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);

        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
