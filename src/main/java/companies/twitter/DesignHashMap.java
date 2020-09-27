package companies.twitter;

public class DesignHashMap {
    class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] array;
    int capacity;

    /** Initialize your data structure here. */
    public DesignHashMap() {
        this.capacity = 1000;
        array = new Node[this.capacity];
        for(int i=0; i<1000; i++) {
            array[i] = new Node(-1, -1);
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashcode = key%this.capacity;
        Node pre = findPreNode(array[hashcode], key);
        if(pre.next==null) {
            pre.next = new Node(key, value);
        } else {
            pre.next.value = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashcode = key%this.capacity;
        Node pre = findPreNode(array[hashcode], key);
        if(pre.next==null) {
            return -1;
        } else {
            return pre.next.value;
        }
    }

    private Node findPreNode(Node head, int key) {
        Node pre = head;
        while(pre.next!=null) {
            if(pre.next.key==key) {
                break;
            }
            pre = pre.next;
        }

        return pre;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashcode = key%this.capacity;
        Node pre = findPreNode(array[hashcode], key);
        if(pre.next==null) {
            return;
        } else {
            pre.next = pre.next.next;
        }
    }
}
