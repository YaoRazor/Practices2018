package companies.facebook;

import datastructures.TreeNode;

import java.util.*;

public class CheckCompletenessOfBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isSeen = false;

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur==null) {
                isSeen = true;
            } else {
                if(isSeen) {
                    return false;
                }

                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }

        return true;
    }
}
