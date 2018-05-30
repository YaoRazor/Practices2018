package tree;

import datastructures.ListNode;
import datastructures.TreeNode;


// We can get a O(n) solution for this problem by virtually constructing
// the tree, because when you you have the number of lists, you can always
// use a method to construct a specific balanced binary tree
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBSTNotBest(ListNode head) {

        if(head==null) {
            return null;
        }

        if(head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = new ListNode(-1);
        pre.next = slow;


        while(fast!=null && fast.next!=null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);

        // Need to set the first half's tail as null, this is important for this question
        pre.next = null;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;

    }


    private ListNode currentList;

    public TreeNode sortedListToBST(ListNode head) {

        if(head == null) {
            return null;
        }

        ListNode p = head;
        int n = 0;

        while (p!=null) {
            p=p.next;
            n++;
        }

        currentList = head;

        return toBST(0, n-1);

    }

    private TreeNode toBST(int start, int end) {
        if(start<end) {
            return null;
        }

        int mid = start+(end-start)/2;

        TreeNode leftChild = toBST(start, mid-1);

        TreeNode treeNode = new TreeNode(currentList.val);

        treeNode.left = leftChild;
        currentList =currentList.next;

        treeNode.right = toBST(mid+1, end);

        return treeNode;

    }
}
