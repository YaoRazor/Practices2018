package linkedlist;

import datastructures.ListNode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = head;

        // This is the outside loop
        while(cur!=null) {

            ListNode tmp = cur.next;
            cur.next = null;
            insert(dummyHead, cur);
            cur = tmp;

        }

        return dummyHead.next;

    }


    // This helper function is to insert one node
    private void insert(ListNode headToInsert, ListNode node) {

        ListNode pre = headToInsert;
        ListNode cur = headToInsert.next;

        while(cur!=null) {

            if(node.val<cur.val) {
                pre.next = node;
                node.next = cur;
                return;
            } else {
                pre = cur;
                cur = cur.next;
            }

        }


        pre.next = node;

    }
}
