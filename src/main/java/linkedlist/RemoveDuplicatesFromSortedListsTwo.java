package linkedlist;


import datastructures.ListNode;

public class RemoveDuplicatesFromSortedListsTwo {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummyHead = new ListNode(-1);

        ListNode cur = head;
        dummyHead.next =head;
        ListNode pre = dummyHead;


        while(cur!=null && cur.next !=null) {

            if(cur.val!=cur.next.val) {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            } else {

                do {
                    cur = cur.next;
                } while (cur.next!=null && cur.val == cur.next.val);

                cur = cur.next;

            }

        }

        //这一句很重要
        pre.next = cur;

        return dummyHead.next;

    }
}
