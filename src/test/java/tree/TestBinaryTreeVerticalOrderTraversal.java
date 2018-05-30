package tree;

import org.junit.Test;

import java.util.List;

import datastructures.TreeNode;

/**
 * Created by yawang on 5/14/18.
 */
public class TestBinaryTreeVerticalOrderTraversal {


    @Test
    public void testBinaryTreeVerticalOrderTraversal() {

        BinaryTreeVerticalOrderTraversal binaryTreeVerticalOrderTraversal = new BinaryTreeVerticalOrderTraversal();


        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(-1);

        List<List<Integer>> ans = binaryTreeVerticalOrderTraversal.verticalOrder(root);

        return;

    }
}
