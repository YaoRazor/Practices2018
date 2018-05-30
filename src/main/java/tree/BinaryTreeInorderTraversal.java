package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import datastructures.TreeNode;


// TODO: Investigate Morris traversal

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
        inorderTraversal(root, integerList);
        return integerList;
    }

    private void inorderTraversal(TreeNode root, List<Integer> integerList) {
        if(root!=null) {
            inorderTraversal(root.left, integerList);
            integerList.add(root.val);
            inorderTraversal(root.right, integerList);
        } else {
            return;
        }
    }


    public List<Integer> inorderTraversalInterative(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();

        TreeNode cur = root;
        Stack<TreeNode> formerNodes = new Stack<>();

        while(cur!=null || !formerNodes.isEmpty()) {

            if(cur!=null) {
                formerNodes.push(cur);
                cur = cur.left;
            } else {
                cur = formerNodes.pop();
                integerList.add(cur.val);
                cur = cur.right;
            }
        }


        return integerList;
    }
}
