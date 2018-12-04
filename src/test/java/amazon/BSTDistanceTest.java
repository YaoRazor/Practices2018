package amazon;

import datastructures.TreeNode;
import org.junit.Test;

public class BSTDistanceTest {


    @Test
    public void test() {

        BSTDistance bstDistance = new BSTDistance();

        int[] a = {5, 6, 3, 1, 2, 4};
        TreeNode root = bstDistance.buildBST(a);

        //
        //         5
        //     3      6
        //  1     4
        //    2

        System.out.println(bstDistance.bstDistance(a, a.length, 2, 4));

        System.out.println(bstDistance.bstDistance(a, a.length, 2, 6));

        System.out.println(bstDistance.bstDistance(a, a.length, 5, 2));

        System.out.println(bstDistance.bstDistance(a, a.length, 2, 5));

        System.out.println(bstDistance.bstDistance(a, a.length, 1, 3));

        System.out.println(bstDistance.bstDistance(a, a.length, 1, 4));

        System.out.println(bstDistance.bstDistance(a, a.length, 1, 1));

        System.out.println(bstDistance.bstDistance(a, a.length, 5, 4));

        System.out.println(bstDistance.bstDistance(a, a.length, 6, 4));

        System.out.println(bstDistance.bstDistance(a, a.length, 5, 5));

        System.out.println(bstDistance.bstDistance(a, a.length, 1, 5));

        System.out.println(bstDistance.bstDistance(a, a.length, 0, 7));
        return;

    }

    @Test
    public void test2() {
        NodeDistanceTwo nodeDistanceTwo = new NodeDistanceTwo();
        int[] a = {5, 6, 3, 1, 2, 4};

        System.out.println(nodeDistanceTwo.bstDistance(a, a.length, 2, 4));

        System.out.println(nodeDistanceTwo.bstDistance(a, a.length, 2, 6));

        System.out.println(nodeDistanceTwo.bstDistance(a, a.length, 5, 2));

        System.out.println(nodeDistanceTwo.bstDistance(a, a.length, 2, 5));

        System.out.println(nodeDistanceTwo.bstDistance(a, a.length, 1, 3));

        System.out.println(nodeDistanceTwo.bstDistance(a, a.length, 1, 4));

        System.out.println(nodeDistanceTwo.bstDistance(a, a.length, 1, 1));

        System.out.println(nodeDistanceTwo.bstDistance(a, a.length, 5, 4));

        System.out.println(nodeDistanceTwo.bstDistance(a, a.length, 6, 4));

        System.out.println(nodeDistanceTwo.bstDistance(a, a.length, 5, 5));

        System.out.println(nodeDistanceTwo.bstDistance(a, a.length, 1, 5));

        System.out.println(nodeDistanceTwo.bstDistance(a, a.length, 0, 7));
    }
}
