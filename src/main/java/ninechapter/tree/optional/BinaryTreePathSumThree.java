package ninechapter.tree.optional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BinaryTreePathSumThree {

   class ParentTreeNode {
      public int val;
      public ParentTreeNode parent, left, right;
   }

    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        List<ParentTreeNode> nodes = new ArrayList<>();

        preOrder(root, nodes);

        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();

        for(ParentTreeNode node: nodes) {
            dfs(node, ans, cur, target, new HashSet<>());
        }

        return ans;
    }

    // Consider this tree as a graph, use set to deduplicate. Normally you don't need to deduplicate
    // for binary tree, but since this tree can go back to original nodes, that's why we need to dedup
    // using set, the other way is to track the previous node and do not travel back to previous nodes.
    private void dfs(ParentTreeNode root, List<List<Integer>> ans, LinkedList<Integer> cur, int target, Set<ParentTreeNode> set) {
        if(root==null || set.contains(root)) {
            return;
        }

        cur.add(root.val);
        set.add(root);
        target-=root.val;
        if(target==0) {
            ans.add(new LinkedList<>(cur));
        }

        dfs(root.parent, ans, cur, target, set);
        dfs(root.left, ans, cur, target, set);
        dfs(root.right, ans, cur, target, set);

        cur.removeLast();
        set.remove(root);
    }

    // Get all nodes in the tree
    private void preOrder(ParentTreeNode root, List<ParentTreeNode> nodes) {
        if(root==null) {
            return;
        }

        nodes.add(root);
        preOrder(root.left, nodes);
        preOrder(root.right, nodes);
    }
}
