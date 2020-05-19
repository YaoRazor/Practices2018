package ninechapter.tree.optional;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import datastructures.TreeNode;


public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> integerList = new LinkedList<>();

        if(root==null) {
            return integerList;
        }

        Stack<TreeNode> formerNodes = new Stack<>();
        formerNodes.push(root);

        while (!formerNodes.isEmpty()) {

            TreeNode cur = formerNodes.pop();
            integerList.addFirst(cur.val);

            if(cur.left != null) {
                formerNodes.push(cur.left);
            }

            if(cur.right != null) {
                formerNodes.push(cur.right);
            }

        }
        return integerList;
    }
}
