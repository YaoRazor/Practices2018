package ninechapter.hash_and_heap;

import datastructures.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists==null || lists.length==0) {
            return null;
        }

        return mergeLists(lists, 0, lists.length-1);
    }


    private ListNode mergeLists(ListNode[] lists, int start, int end) {

        if(start == end) {
            return lists[start];
        } else if(start>end) {
            return null;
        }

        int mid = start+(end-start)/2;


        ListNode l1 = mergeLists(lists, start, mid);
        ListNode l2 = mergeLists(lists, mid+1, end);


        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;


        while (l1!=null && l2!=null) {

            if(l1.val<l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }

            head = head.next;
        }

        ListNode rest = l1!=null? l1:l2;

        head.next = rest;



        return dummyHead.next;
    }



    // Prefer heap solution as it is simpler
    public ListNode mergeKLists(List<ListNode> lists) {
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
