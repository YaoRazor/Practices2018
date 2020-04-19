package ninechapter.hash_and_heap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqueNumberInDataStreamTwo {
    class Node {
        int key;
        Node pre;
        Node next;

        public Node(int key) {
            this.key = key;
        }
    }

    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private Set<Integer> set;


    public FirstUniqueNumberInDataStreamTwo(){
        // do intialization if necessary
        map = new HashMap<>();
        set = new HashSet<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
    }

    private void deleteNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }
    /**
     * @param num: next number in stream
     * @return: nothing
     */
    public void add(int num) {
        if(set.contains(num)) {
            return;
        }

        if(map.containsKey(num)) {
            Node cur = map.get(num);
            deleteNode(cur);
            map.remove(num);
            set.add(num);
        } else {
            Node cur = new Node(num);
            Node pre = tail.pre;
            tail.pre = cur;
            cur.next = tail;
            pre.next = cur;
            cur.pre = pre;
            map.put(num, cur);
        }
    }

    /**
     * @return: the first unique number in stream
     */
    public int firstUnique() {
        return head.next.key;
        // write your code here
    }
}
