package companies.amazon;

import datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BSTDistance {

    public  int bstDistance(int[] values, int n, int node1, int node2) {

        if(node1 == node2) {
            return 0;
        }

        TreeNode root = buildBST(values);
        TreeNode lca = lowestCommonAncestor(root, node1, node2);

        int level1 = -1;
        int level2 = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(lca);
        int level = 0;
        while(!queue.isEmpty()) {
            if (level1 > 0 && level2 > 0) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == node1) {
                    level1 = level;
                }
                if (cur.val == node2) {
                    level2 = level;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            level++;
        }

        if(level1==-1 || level2==-1) {
            return -1;
        }

        return level1 + level2;


    }


    public TreeNode buildBST(int[] values) {

        TreeNode root = null;
        for (int val : values) {
            root = insert(root, val);
        }

        return root;

    }


    private TreeNode insert(TreeNode root, int value) {

        if(root==null) {
            return new TreeNode(value);
        }

        if(root.val > value) {
            root.left = insert(root.left, value);
        }

        if(root.val < value) {
            root.right = insert(root.right, value);
        }

        return root;


    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null) {
            return root;
        }
        while((root.val - p) * (root.val - q) > 0) {
            if (root.val > p) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
