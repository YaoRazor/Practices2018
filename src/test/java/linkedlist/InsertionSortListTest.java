package linkedlist;

import org.junit.Test;

import datastructures.ListNode;

public class InsertionSortListTest {


    @Test
    public void test() {

        ListNode head = new ListNode(1);

        ListNode originalHead = head;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(2);
    }
}
