package linkedlist;


import datastructures.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(-1);
        ListNode small = dummyHead1;
        ListNode dummyHead2 = new ListNode(-2);
        ListNode big = dummyHead2;

        ListNode cur= head;

        while(cur!=null) {

            if(cur.val<x) {
                small.next = cur;
                small = small.next;
            } else {
                big.next = cur;
                big = big.next;
            }

            cur = cur.next;
        }

        small.next = dummyHead2.next;
        // Do not forget to set big.next=null here
        big.next = null;
        return dummyHead1.next;
    }
}
