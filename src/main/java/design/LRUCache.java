package design;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(map.get(key)==null) {
            return -1;
        } else {
            Node node = map.get(key);
            updateNode(node);
            return node.value;
        }
    }

    public void put(int key, int value) {

        if(map.containsKey(key)) {

            Node node = map.get(key);
            node.value = value;
            updateNode(node);

        } else {

            Node node = new Node(key, value);
            map.put(key, node);
            moveToHead(node);

            if(map.size()> capacity) {

                Node toDel = tail.pre;
                deleteNode(toDel);
                map.remove(toDel.key);

            }
        }

    }

    private void deleteNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;
    }


    private void moveToHead(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.pre = head;
        node.next = headNext;
        headNext.pre = node;
    }


    private void updateNode(Node node) {
        deleteNode(node);
        moveToHead(node);
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


