package companies.twitter;

public class DesignHashMap {
    private Node[] data;
    private int capacity;

    /** Initialize your data structure here. */
    public DesignHashMap() {
        this.capacity = 1000000;
        data = new Node[this.capacity];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        if(data[index]==null) {
            data[index] = new Node(-1, -1);
        }

        Node pre = findPre(data[index], key);
        if(pre.next==null) {
            pre.next = new Node(key, value);
        } else {
            pre.next.value = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        if(data[index]==null) {
            return -1;
        }

        Node pre = findPre(data[index], key);
        if(pre.next==null) {
            return -1;
        }
        return pre.next.value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        if(data[index]==null) {
            return;
        }

        Node pre = findPre(data[index], key);
        if(pre.next==null) {
            return;
        } else {
            pre.next = pre.next.next;
        }

    }

    private int getIndex(int key) {
        int hashCode = key%this.capacity;
        if(hashCode<0) {
            hashCode+=this.capacity;
        }
        return hashCode;
    }

    private Node findPre(Node bucket, int key) {
        Node pre = bucket;
        Node cur = pre.next;
        while(cur!=null && cur.key!=key) {
            pre = cur;
            cur = cur.next;
        }

        return pre;
    }

    class Node {
        int key, value;
        Node next;
        Node(final int key, final int value) {
            this.key = key;
            this.value = value;
        }
    }
}
