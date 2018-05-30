package linkedlist;

import datastructures.ListNode;

/**
 * Created by yawang on 4/22/18.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null || l2==null) {
            return l1==null? l2:l1;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;


        while(l1!=null && l2!=null) {

            if(l1.val<=l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }

            head = head.next;
        }


        if(l1!=null) {
            head.next = l1;
        } else {
            head.next = l2;
        }

        return dummyHead.next;

    }
}
