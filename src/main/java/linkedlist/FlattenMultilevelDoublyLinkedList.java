package linkedlist;

import datastructures.Node;

public class FlattenMultilevelDoublyLinkedList {

    public Node flatten(Node head) {

        if(head == null) {
            return null;
        }

        Node dummyHead = new Node();
        dummyHead.next = head;

        flattern(head);

        return dummyHead.next;
    }


    private Node flattern(Node head) {

        while (head.next!=null) {

            if(head.child!=null) {

                Node tmp = head.child;
                Node next = head.next;

                Node tail = flattern(head.child);

                head.next = tmp;

                tmp.prev = head;
                tail.next = next;
                next.prev = tail;
                head = next;

            } else {
                head = head.next;
            }
        }

        return head;
    }

}
