package design;

import java.util.HashMap;
import java.util.Map;

// This solution is awesome, just remember it and practice it every week
// Also you will take a lot about cache in your project, so be prepared to
// face problems of cache
class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        } else {
            Node cur = map.get(key);
            updateNode(cur);
            return cur.value;
        }
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            Node cur = new Node(key, value);
            map.put(key, cur);
            moveToHead(cur);
            if(map.size()>capacity) {
                Node toDel = tail.pre;
                deleteNode(toDel);
                map.remove(toDel.key);
            }
        } else {
            Node cur = map.get(key);
            cur.value = value;
            updateNode(cur);
        }
    }

    private void deleteNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void updateNode(Node node) {
        deleteNode(node);
        moveToHead(node);
    }

    private void moveToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.pre = head;
        node.next = next;
        next.pre = node;
    }

    class Node {
        Node pre, next;
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}


