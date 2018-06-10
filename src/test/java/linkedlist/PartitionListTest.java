package linkedlist;


import org.junit.Test;

import datastructures.ListNode;

public class PartitionListTest {


    @Test
    public void test() {

        PartitionList partitionList = new PartitionList();


        ListNode head = new ListNode(1);

        ListNode originalHead = head;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(2);

        ListNode newList = partitionList.partition(originalHead, 3);

    }
}
