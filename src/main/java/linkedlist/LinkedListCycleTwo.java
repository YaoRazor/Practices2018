package linkedlist;

import datastructures.ListNode;

// F = b is incorrect, which is obvious when F is very large and C(C is total length of cycle) is very small. Rather, from 2*d(tortoise) = d(hare),
// we have 2(F+a) = F+nC+a, for some integer n, so F+a = nC, or F = nC-a. In phase two, you dispatch another tortoise
// from the head of the list, and slow down the hare in the cycle to advance one node per step. After F steps the tortoise
// will travel F nodes, and the hare will travel F=nC-a nodes. The hare started at F+a = F+a%C, so the hare's position
// after F steps is F+(a+F)%C = F+(a+nC-a)%C = F. So the tortoise and the (slow) hare will meet at the start of the cycle.
public class LinkedListCycleTwo {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast !=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                break;
            }
        }

        if(fast ==null || fast.next ==null) {
            return null;
        }

        fast = head;

        while(slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
