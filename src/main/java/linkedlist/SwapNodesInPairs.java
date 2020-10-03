package linkedlist;

import datastructures.ListNode;

public class SwapNodesInPairs {
    // This method is O(n)
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = cur;
        ListNode pre = dummyHead;

        while(cur!=null && cur.next!=null) {
            ListNode tmp = cur.next.next;
            cur.next.next = cur;
            pre.next = cur.next;
            cur.next = tmp;
            pre = cur;
            cur = tmp;
        }

        return dummyHead.next;
    }

    // TC: O(N). SC: 也是0(N)，因为需要压栈N/2次
    public ListNode swapPairsRecursive(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }

        ListNode next = head.next.next;
        head.next.next = head;
        ListNode ans = head.next;
        head.next = swapPairsRecursive(next);
        return ans;
    }
}
