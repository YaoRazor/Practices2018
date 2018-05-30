package linkedlist;

import datastructures.ListNode;


public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = cur;
        ListNode pre = dummyHead;

        while(cur!=null && cur.next!=null) {
            ListNode tmp = cur.next.next;
            cur.next.next = cur;
            pre.next = cur.next;
            cur.next = tmp;
            pre = cur;
            cur = tmp;
        }

        return dummyHead.next;
    }
}
