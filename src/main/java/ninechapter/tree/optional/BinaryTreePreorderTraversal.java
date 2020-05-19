package ninechapter.tree.optional;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import datastructures.TreeNode;


public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> integerList = new LinkedList<>();

        if(root==null) {
            return integerList;
        }

        Stack<TreeNode> formerNodes = new Stack<>();
        formerNodes.push(root);

        while (!formerNodes.isEmpty()) {

            TreeNode cur = formerNodes.pop();
            integerList.add(cur.val);

            if(cur.right != null) {
                formerNodes.push(cur.right);
            }

            if(cur.left != null) {
                formerNodes.push(cur.left);
            }

        }
        return integerList;
    }
}
