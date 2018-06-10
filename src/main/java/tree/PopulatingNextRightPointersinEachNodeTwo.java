package tree;

import java.util.LinkedList;
import java.util.Queue;

import datastructures.TreeLinkNode;

/**
 * Created by yawang on 5/30/18.
 */
public class PopulatingNextRightPointersinEachNodeTwo {

    public void connectIterative(TreeLinkNode root) {

        if(root==null) {
            return;
        }

        while (root!=null) {

            TreeLinkNode dummy = new TreeLinkNode(-1);
            TreeLinkNode tempHead = dummy;

            while (tempHead!=null) {
                if(root.left!=null) {
                    tempHead.next = root.left;
                    tempHead = tempHead.next;
                }

                if(root.right!=null) {
                    tempHead.next = root.right;
                    tempHead = tempHead.next;
                }

                root = root.next;
            }

            root = dummy.next;

        }

    }

}
