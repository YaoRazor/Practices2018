package linkedlist;

import datastructures.ListNode;


public class LinkedListCycleTwo {
    public ListNode detectCycle(ListNode head) {
        if(head==null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast) {
                break;
            }
        }

        if(fast.next==null || fast.next.next==null) {
            return null;
        }

        slow = head;
        while(slow!=fast) {
            slow=slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
