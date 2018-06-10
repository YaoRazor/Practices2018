package graph;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CopyListWithRandomPointer {
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
