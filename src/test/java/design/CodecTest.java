package design;

import org.junit.Test;

import datastructures.TreeNode;

/**
 * Created by yawang on 5/31/18.
 */
public class CodecTest {


    @Test
    public void test() {
        Codec codec = new Codec();

        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);

        String ans = codec.serialize(root);


        TreeNode test = codec.deserialize(ans);

        System.out.println(ans);

    }

    @Test
    public void test2() {
        String[] arrayTwo = "1,2,".split(",");
        System.out.println(arrayTwo);

    }
}
