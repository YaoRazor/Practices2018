package linkedlist;

import datastructures.ListNode;

/**
 * Created by yawang on 4/22/18.
 */
public class IntersectionOfTwoLinkedLists {

    // This is the optimal solution, we can get the length of each list first, that would be
    // the brute force solution, see: https://github.com/Aaron1Alicia/LeetCodePractices2015/blob/master/src/edu/nyu/yaowang/leetcode/linkedlist/IntersectionOfTwoLinkedList.java
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
}
