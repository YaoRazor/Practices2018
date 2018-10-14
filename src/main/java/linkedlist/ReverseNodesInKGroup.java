package linkedlist;

import datastructures.ListNode;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = pre;

        while(cur!=null) {
            int cnt = k;

            while(cnt>0 && cur.next!=null) {
                cur = cur.next;
                cnt--;
            }

            if(cnt>0) {
                break;
            }

            ListNode next = cur.next;
            cur.next = null;

            ListNode tail = pre.next;
            ListNode newHead = reverseList(pre.next);
            pre.next = newHead;
            pre = tail;
            cur = pre;
            pre.next = next;

        }

        return dummyNode.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur = head;

        while(cur!=null) {

            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
