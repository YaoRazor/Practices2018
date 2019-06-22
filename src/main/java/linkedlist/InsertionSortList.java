package linkedlist;

import datastructures.ListNode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = head;

        while(cur!=null) {
            ListNode newHead = dummyHead;

            while(newHead.next!=null) {
                if(cur.val<newHead.next.val) {
                    break;
                } else {
                    newHead = newHead.next;
                }

            }
            ListNode newListNext = newHead.next ;
            newHead.next = cur;
            ListNode next = cur.next;
            cur.next = newListNext;
            cur = next;
        }

        return dummyHead.next;
    }
}
