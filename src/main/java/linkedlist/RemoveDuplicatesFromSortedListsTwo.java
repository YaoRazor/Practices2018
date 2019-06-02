package linkedlist;


import datastructures.ListNode;

public class RemoveDuplicatesFromSortedListsTwo {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode cur = head;

        while(cur!=null && cur.next!=null) {

            if(cur.val!=cur.next.val) {
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;
                continue;
            }

            int val = cur.val;

            while(cur!=null && cur.val==val) {
                cur = cur.next;
            }

        }

        pre.next = cur;
        return dummy.next;
    }
}
