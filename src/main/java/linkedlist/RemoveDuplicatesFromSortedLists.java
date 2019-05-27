package linkedlist;


import datastructures.ListNode;

public class RemoveDuplicatesFromSortedLists {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while(cur!=null) {

            if(pre!=null && pre.val==cur.val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }
}
