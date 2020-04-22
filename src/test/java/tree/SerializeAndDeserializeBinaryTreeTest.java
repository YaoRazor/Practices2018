package tree;

import ninechapter.bfs.SerializeAndDeserializeBinaryTree;
import datastructures.TreeNode;
import org.junit.Test;

public class SerializeAndDeserializeBinaryTreeTest {


    SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();


    @Test
    public void test() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);


        String tmp = serializeAndDeserializeBinaryTree.serialize(root);

        System.out.println(tmp);

    }


}
