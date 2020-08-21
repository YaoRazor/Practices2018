package ninechapter.hash_and_heap;

import datastructures.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists==null || lists.size()==0) {
            return null;
        }

        return mergeKLists(lists, 0, lists.size()-1);
    }

    private ListNode mergeKLists(List<ListNode> lists, int start, int end) {
        if(start==end) {
            return lists.get(start);
        }

        int mid = (start+end)/2;

        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid+1, end);

        ListNode dummyNode = new ListNode(-1);
        ListNode head = dummyNode;

        while(left!=null && right!=null) {

            if(left.val<=right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }

            head = head.next;
        }

        head.next = left!=null? left:right;

        return dummyNode.next;
    }

    // Prefer heap solution as it is simpler
    // TC: nlog(k), k is the number of lists, n is total number of nodes
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2)-> l1.val-l2.val);

        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        for(ListNode list: lists) {
            if(list!=null) {
                pq.offer(list);
            }
        }

        while(!pq.isEmpty()) {
            ListNode cur = pq.poll();
            head.next = cur;
            head = head.next;
            if(cur.next!=null) {
                pq.offer(cur.next);
            }
        }

        return dummyHead.next;
    }
}
