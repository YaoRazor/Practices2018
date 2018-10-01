package linkedlist;

import datastructures.ListNode;

import java.util.List;

public class ReverseLinkedListTwo {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n || head==null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode preHead = dummyHead;

        int cnt = 1;

        while (true) {

            if(m==cnt) {

                ListNode tail = cur;

                int num = m-n;

                ListNode next = cur.next;

                while (num>0) {
                    ListNode tmp = next.next;
                    next.next = cur;
                    cur = next;
                    next = tmp;

                    num--;
                }

                preHead.next = cur;
                tail.next = next;
                break;

            } else {
                preHead = cur;
                cur = cur.next;
                cnt++;
            }

        }

        return dummyHead.next;
    }

}
