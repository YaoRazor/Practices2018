package graph;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CopyListWithRandomPointer {

    // This is O(1) space, you have to do it in three passes, you can't do it in two passes
    // Reason is here: https://leetcode.com/problems/copy-list-with-random-pointer/discuss/164674/Why-is-two-pass-with-O(1)-space-not-possible
    // Basically some random pointer can point to the nodes before current node, if you decouple at the same time, that
    // relationship is already lost
    public RandomListNode copyRandomListWithConstantSpace(RandomListNode head) {

        if(head==null) {
            return null;
        }

        RandomListNode cur = head;

        // Clone the list and put the copy to the next pointer of each original pointer
        while(cur!=null) {

            RandomListNode next = cur.next;
            RandomListNode copy = new RandomListNode(cur.label);

            cur.next = copy;
            copy.next = next;
            cur = next;
        }

        cur = head;

        // Allocate the random pointer
        while(cur!=null) {

            if(cur.random!=null) {
                cur.next.random = cur.random.next;
            }

            cur = cur.next.next;

        }

        cur = head;
        RandomListNode ans = cur.next;
        RandomListNode newHead = cur.next;


        // Decouple two list
        while(cur!=null) {

            RandomListNode copy = cur.next;
            cur.next = copy.next;
            cur = cur.next;
            if(cur!=null) {
                copy.next = cur.next;
            } else {
                copy.next = null;
            }

        }

        return ans;
    }




    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) {
            return head;
        }

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        Queue<RandomListNode> queue = new LinkedList<>();
        queue.add(head);

        RandomListNode copy = new RandomListNode(head.label);
        map.put(head, copy);

        while (!queue.isEmpty()) {

            RandomListNode cur = queue.poll();

            if(cur.next!=null) {
                if(!map.containsKey(cur.next)) {
                    RandomListNode currentCopy = new RandomListNode(cur.next.label);
                    map.put(cur.next, currentCopy);
                    queue.add(cur.next);
                }

                map.get(cur).next = map.get(cur.next);
            }


            if(cur.random!=null) {
                if(!map.containsKey(cur.random)) {
                    RandomListNode currentCopy = new RandomListNode(cur.random.label);
                    map.put(cur.random, currentCopy);
                    queue.add(cur.random);
                }

                map.get(cur).random = map.get(cur.random);
            }

        }

        return map.get(head);
    }
}


class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}
