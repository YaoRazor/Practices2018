package ninechapter.optional.optiional;

import datastructures.ListNode;

public class
MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode head = dummyNode;

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

        head.next = l1!=null? l1:l2;
        return dummyNode.next;
    }
}
