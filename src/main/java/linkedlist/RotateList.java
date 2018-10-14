package linkedlist;

import datastructures.ListNode;

// http://fisherlei.blogspot.com/2013/01/leetcode-rotate-list.html
// 这一题有两个关键的思路，一个是求出长度然后取模。另一个是把尾指针和头连在一起，
// 这样就不用重新计算结尾了
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || head.next==null) {
            return head;
        }

        int cnt = 0;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while(cur.next!=null) {
            cur = cur.next;
            cnt++;
        }

        // 直接把尾指针和头指针连在一起
        cur.next = head;
        int tmp = cnt - k%cnt;

        while(tmp>0) {
            cur = cur.next;
            tmp--;
        }

        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;

    }

}
