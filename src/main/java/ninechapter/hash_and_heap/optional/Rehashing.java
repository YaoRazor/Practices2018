package ninechapter.hash_and_heap.optional;

import datastructures.ListNode;

public class Rehashing {

    public ListNode[] rehashing(ListNode[] hashTable) {
        int Oldsize = hashTable.length;
        int size = Oldsize*2;

        ListNode[] newTable = new ListNode[size];

        for(ListNode cur: hashTable) {
            ListNode head = cur;

            while(head!=null) {
                int key = head.val;

                while(key<0) {
                    key+=size;
                }

                ListNode next = head.next;
                insertIntoTable(newTable, head, key%size);
                head = next;
            }
        }

        return newTable;
    }

    private void insertIntoTable(ListNode[] table, ListNode cur, int hashCode) {
        if(table[hashCode]==null) {
            table[hashCode] = cur;
            cur.next = null;
            return;
        }

        ListNode head = table[hashCode];
        while(head.next!=null) {
            head = head.next;
        }
        head.next = cur;
        cur.next = null;;
    }
}
