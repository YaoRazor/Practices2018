package design;

import org.junit.Test;

import datastructures.TreeNode;

public class SerializeAndDeserializeBSTTest {


    @Test
    public void test() {

        SerializeAndDeserializeBST bst = new SerializeAndDeserializeBST();
        TreeNode root = new TreeNode(2);
        root.left= new TreeNode(1);
        root.right = new TreeNode(3);

        String tmp =bst.serialize(root);

        TreeNode cur = bst.deserialize(tmp);


        return;


    }
}
