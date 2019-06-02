package linkedlist;


import datastructures.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode cur = head;

        while(cur!=null) {
            if(cur.val!=val) {
                pre.next = cur;
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }

            cur = cur.next;
        }

        return dummy.next;
    }
}
