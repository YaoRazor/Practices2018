package miscellaneous;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Node {
    int value;
    Node next;
    Node random;

    public Node(int value) {
        this.value = value;
    }
}


public class Solution {

//    a -> b -> c

//    a.
//
//    //map{a, a*}
//    [a          ]
//
//    cur.next
//
//    a* -> c*

/*
    a.next = b;
    a.rondom =

    [a, b, c]
    a.

    a->a*
    a->a.next
    a->



    a->b->c->d
    a.random =c
*/


    public Node copyRandomLinkedList(final Node head) {

        if(head==null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();


        Node copyOfHead = new Node(head.value);
        queue.add(head);

        map.put(head, copyOfHead);

        Node cur = head;

        // [a, b] a.next = b
        // map: a->a* b->b*
        //  a*.next = b*;
        while(cur.next!=null) {

            if(!map.containsKey(cur.next)) {
                Node currentCopy = new Node(cur.next.value);
                map.put(cur.next, currentCopy);
            }

            map.get(cur).next = map.get(cur.next);

            cur = cur.next;
        }

       // a.next = b, a.random = c


        cur = head;


        while (cur.next!=null) {

            if(cur.random!=null) {

                if(!map.containsKey(cur.random)) {
                    Node currentCopy = new Node(cur.random.value);
                    map.put(cur.random, currentCopy);
                }

                map.get(cur).random = map.get(cur.random);

            }

            cur = cur.next;

        }


        return map.get(head);


    }



}
