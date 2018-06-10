package tree;


import datastructures.TreeLinkNode;

// The solution of PopulatingNextRightPointersinEachNodeTwo is much better,
// we just need to use that solution to solve this problem
public class PopulatingNextRightPointersinEachNode {

    public void connectIterative(TreeLinkNode root) {
        if(root==null) {
            return;
        }

        TreeLinkNode head = root;
        TreeLinkNode cur;

        while(head.left!=null) {
            cur = head;

            while (cur!=null) {
                cur.left.next = cur.right;
                if(cur.next!=null) {
                    cur.right.next = cur.next.left;
                }

                cur = cur.next;
            }

            head = head.left;
        }
    }

}
