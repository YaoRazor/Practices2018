package linkedlist;


import datastructures.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {

        ListNode dummyNode = new ListNode(x-1);
        dummyNode.next = head;

        ListNode cur = dummyNode;
        ListNode pre = dummyNode; // keep the nodes that are smaller than x;
        ListNode big;

        while (cur.next!=null && cur.next.val<x) {
            pre.next = cur.next;
            cur = cur.next;
            pre = pre.next;
        }

        if(cur.next==null) {
            return dummyNode.next;
        } else {
            big = cur.next;
        }


        while (cur.next != null) {
            if(cur.next.val<x) {
                pre.next = cur.next;
                cur.next = cur.next.next;
                pre = pre.next;
            } else {
                cur = cur.next;
            }
        }


        pre.next = big;

        return dummyNode.next;

    }
}
