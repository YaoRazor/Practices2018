package tree;

import org.junit.Test;

import datastructures.TreeNode;

public class BinaryTreeUpsideDownTest {

    BinaryTreeUpsideDown binaryTreeUpsideDown = new BinaryTreeUpsideDown();



    @Test
    public void test() {


        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);


        binaryTreeUpsideDown.upsideDownBinaryTree(treeNode);

        return;

    }
}
