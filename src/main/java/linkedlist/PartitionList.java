package linkedlist;


import datastructures.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {

        //创建两个List是这里的关键思想
        ListNode dummyNode1 = new ListNode(-1);
        ListNode dummyNode2 = new ListNode(-1);
        ListNode head1 = dummyNode1;
        ListNode head2 = dummyNode2;

        while(head!=null) {

            if(head.val<x) {
                head1.next = head;
                head1 = head1.next;
            } else {
                head2.next = head;
                head2 = head2.next;
            }

            head = head.next;
        }

        head1.next = dummyNode2.next;
        //注意不要忘记把这里设置成null
        head2.next = null;
        return dummyNode1.next;

    }
}
