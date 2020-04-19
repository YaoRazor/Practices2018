package ninechapter.hash_and_heap;

import java.util.HashMap;
import java.util.Map;

// This solution is awesome, just remember it and practice it every week
// Also you will talk a lot about cache in your project, so be prepared to
// face problems of cache
class LRUCache {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }


    private void deleteNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void moveToHead(Node node) {
        Node tmp = head.next;
        head.next = node;
        node.pre = head;
        node.next = tmp;
        tmp.pre = node;
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
        deleteNode(cur);
        moveToHead(cur);
        return cur.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        Node cur;
        if(!map.containsKey(key)) {
            cur = new Node(key, value);
            map.put(key, cur);
            moveToHead(cur); // There is no need to delete node here, otherwise it will cause exceptions
            if(map.size()>capacity) {
                Node nodeToDlete = tail.pre;
                deleteNode(nodeToDlete);
                map.remove(nodeToDlete.key);
            }
        } else {
            cur = map.get(key);
            cur.value = value;
            deleteNode(cur);
            moveToHead(cur);
        }
    }
}


