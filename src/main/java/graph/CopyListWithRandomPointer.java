package graph;


import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    // This is O(1) space, you have to do it in three passes, you can't do it in two passes
    // Reason is here: https://leetcode.com/problems/copy-list-with-random-pointer/discuss/164674/Why-is-two-pass-with-O(1)-space-not-possible
    // Basically some random pointer can point to the nodes before current node, if you decouple at the same time, that
    // relationship is already lost
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node cur = head;

        while (cur != null) {
            Node copy = new Node(cur.val, null, null);
            Node next = cur.next;
            cur.next = copy;
            copy.next = next;
            cur = next;
        }

        cur = head;

        while (cur != null) {
            Node next = cur.next.next;
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = next;
        }

//        printList(head);
        cur = head;
        Node ans = cur.next;

        while (cur != null) {
            Node next = cur.next.next;
            Node newNode = cur.next;
            cur.next = next;
            if (next == null) {
                break;
            }
            newNode.next = next.next;
            cur = next;
        }

        return ans;
    }

    private void printList(Node node) {
        String ans = "";

        while (node != null) {
            ans += node.val;
            node = node.next;
        }

        System.out.println(ans);
        return;
    }


    public Node copyRandomListWithHashMap(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<Node, Node>();

        // loop 1. copy all the nodes
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val, null, null));
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
