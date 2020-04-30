package ninechapter.hash_and_heap;

import java.util.HashMap;
import java.util.Map;

// This solution is awesome, just remember it and practice it every week
// Also you will talk a lot about cache in your project, so be prepared to
// face problems of cache
class LRUCache {
    class Node {
        public int key;
        public int value;
        public Node pre;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    /*
     * @param capacity: An integer
     */public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.pre = head;
    }


    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        Node cur = map.get(key);
        updateNode(cur);
        return cur.value;
    }

    // This operation is incurred whenever a get or set happens on existing node
    private void updateNode(Node cur) {
        deleteNode(cur);
        moveToHead(cur);
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node cur = map.get(key);
            cur.value = value;
            updateNode(cur);
        } else {
            Node cur = new Node(key, value);
            moveToHead(cur);
            map.put(key, cur);

            if(map.size()>capacity) {
                map.remove(tail.pre.key); // Do not forget to remove key from the map
                deleteNode(tail.pre);
            }
        }
    }

    private void moveToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.pre = head;
        node.next = next;
        next.pre = node;
    }

    private void deleteNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }
}


