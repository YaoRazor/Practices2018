package companies.amazon;

import datastructures.TreeNode;

public class NodeDistanceTwo {
    public static int bstDistance(int[] values, int n, int node1, int node2) {
        TreeNode root = buildBst(values);
        if (root == null) return -1;

        TreeNode p = search(root, node1);
        if (p == null) return -1;

        TreeNode q = search(root, node2);
        if (q == null) return -1;

        if (node1 == node2) return 0;

        TreeNode lca = lca(root, p, q);

        int lenToP = length(lca, p);
        int lenToQ = length(lca, q);
        return lenToP + lenToQ;

    }

    public static TreeNode buildBst(int[] values) {
        TreeNode root = null;
        for (int val : values) {
            root = insert(root, val);
        }

        return root;
    }

    public static TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
        } else if (val < node.val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }

        return node;
    }


//    public static List<Integer> inorder(TreeNode root) {
//        if (root == null) return Collections.emptyList();
//        List<Integer> result = new ArrayList<>();
//        inorder(root, result);
//        return result;
//    }
//
//    private static void inorder(TreeNode node, List<Integer> result) {
//        if (node == null) return;
//        inorder(node.left, result);
//        result.add(node.val);
//        inorder(node.right, result);
//    }

    private static TreeNode search(TreeNode root, int v) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == v) return cur;

            if (v < cur.val) cur = cur.left;
            else cur = cur.right;
        }

        return null;
    }

    private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        int large = Math.max(p.val, q.val);
        int small = Math.min(p.val, q.val);
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == p.val || cur.val == q.val) return cur;
            if (cur.val > large) cur = cur.left;
            else if (cur.val < small) cur = cur.right;
            else return cur;
        }

        return null;
    }

    // Length of path from p to q
    private static int length(TreeNode p, TreeNode q) {
        int len = 0;
        while (p != null && q != null && p.val != q.val) {
            len++;
            if (p.val < q.val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        return len;
    }
}
