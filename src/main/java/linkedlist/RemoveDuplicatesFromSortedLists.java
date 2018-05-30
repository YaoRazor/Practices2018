package linkedlist;


import datastructures.ListNode;

public class RemoveDuplicatesFromSortedLists {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode cur = head;

        while (cur.next !=null) {

            if(cur.val != cur.next.val) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }

        return head;

    }
}
