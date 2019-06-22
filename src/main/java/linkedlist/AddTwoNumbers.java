package linkedlist;

import datastructures.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int value = 0;

        while (l1!=null || l2!=null) {

            if(l1!=null) {
                value+=l1.val;
                l1 = l1.next;
            }

            if(l2!=null) {
                value+=l2.val;
                l2 = l2.next;
            }

            ListNode cur = new ListNode(value%10);
            pre.next = cur;
            pre = cur;
            value = value/10;
        }

        if(value>0) {
            pre.next = new ListNode(value);
        }

        return dummy.next;

    }
}
