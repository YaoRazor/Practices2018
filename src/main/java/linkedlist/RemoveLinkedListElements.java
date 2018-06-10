package linkedlist;


import datastructures.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur;

        while (pre.next!=null) {
            cur = pre.next;

            if(cur.val==val) {
                pre.next = cur.next;
                continue;
            }

            pre = pre.next;

        }

        return dummy.next;
    }
}
