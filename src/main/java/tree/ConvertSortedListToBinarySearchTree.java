package tree;

import datastructures.ListNode;
import datastructures.TreeNode;

public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) {
            return null;
        } else if(head.next==null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while(fast!=null && fast.next!=null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        pre.next = null;
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(slow.next);
        root.left = left;
        root.right = right;
        return root;
    }

}
