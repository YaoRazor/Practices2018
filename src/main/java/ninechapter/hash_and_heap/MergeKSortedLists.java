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
    public ListNode mergeKListsUsingHeap(List<ListNode> lists) {
        ListNode dummyNode = new ListNode(-1);
        ListNode head = dummyNode;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new NodeComparator());

        for(ListNode node: lists) {
            populatePriorityQueue(node, pq);
        }

        while(!pq.isEmpty()) {
            head.next = pq.poll();
            head = head.next;
        }

        return dummyNode.next;
    }


    class NodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode n1, ListNode n2) {
            return n1.val - n2.val;
        }
    }


    private void populatePriorityQueue(ListNode node, PriorityQueue<ListNode> pq) {
        ListNode cur = node;
        while(cur!=null) {
            pq.offer(cur);
            cur = cur.next;
        }
    }


}
