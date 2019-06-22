package linkedlist;

import datastructures.ListNode;

public class SortList {

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        // 使用pre的原因是如果LinkedList只有2个Node的话，会分割成2个Node和0个Node, 然后无限循环
        // 所以要么加上pre, 要么用fast.next!=null && fast.next.next!=null
        while(fast!=null && fast.next!=null) { // alternative: while(fast.next!=null && fast.next.next!=null)
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l1 = head;
        ListNode l2 = pre.next;
        pre.next = null;


        ListNode sortedl1 = sortList(l1);
        ListNode sortedl2 = sortList(l2);

        return mergeTwoLists(sortedl1, sortedl2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
