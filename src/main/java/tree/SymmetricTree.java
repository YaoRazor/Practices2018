package tree;

import java.util.LinkedList;

import datastructures.TreeNode;

/**
 * Created by yawang on 5/20/18.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) {
            return true;
        } else {
            return isSymmetric(root.left, root.right);
        }

    }


    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if(p==null && q==null) {
            return true;
        } else if(p!=null && q!=null) {

            return p.val == q.val &&
                    isSymmetric(p.left, q.right) && isSymmetric(p.right, p.left);
        } else {
            return false;
        }
    }


    public boolean isSymmetricBFS(TreeNode root) {
        if(root == null) {
            return true;
        }


        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left==null && right!=null) {
                return false;
            }

            if(right == null && left!=null) {
                return false;
            }


            if(left!=null && right!=null) {

                if(left.val!=right.val) {
                    return false;
                }

                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);
            }

        }


        return true;

    }

}
