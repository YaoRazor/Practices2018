package tree;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import datastructures.TreeNode;

/**
 * Created by yawang on 4/22/18.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root==null) {
            return true;
        }


        Stack<TreeNode> formerNodes = new Stack<>();
        formerNodes.push(root);
        TreeNode cur = root.left;
        TreeNode pre = null;

        while (cur!=null || formerNodes.size()>0) {

            if(cur!=null) {
                formerNodes.push(cur);
                cur = cur.left;
            } else {
                cur = formerNodes.pop();

                if(pre!=null && pre.val>=cur.val) {
                    return false;
                }
                pre = cur;
                cur = cur.right;
            }
        }



        return true;
    }
}
