package ninechapter.twopointers.related;

import datastructures.ListNode;


public class IntersectionOfTwoLinkedLists {

    // fancy solution
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        //if a & b have same len, then they either will meet of stop after first iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }


    //普通解法: TC:O(n)
    public ListNode getIntersectionNodeNormal(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) {
            return null;
        }

        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        if(lengthA<lengthB) {
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
        }

        int diff = Math.abs(lengthA-lengthB);

        while(diff>0) {
            headA = headA.next;
            diff--;
        }

        while(headA!=null) {
            if(headA==headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }

        }

        return null;
    }

    private int getLength(ListNode listNode) {
        int cnt = 0;
        while(listNode!=null) {
            cnt++;
            listNode = listNode.next;
        }

        return cnt;
    }
}
