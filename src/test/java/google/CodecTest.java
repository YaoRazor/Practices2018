package google;

import datastructures.TreeNode;
import org.junit.Test;

public class CodecTest {


    @Test
    public void test() {

        Codec codec = new Codec();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(codec.serialize(root));

    }
}
