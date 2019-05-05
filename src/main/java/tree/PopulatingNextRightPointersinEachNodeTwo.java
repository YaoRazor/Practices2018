package tree;


import datastructures.TreeLinkNode;


public class PopulatingNextRightPointersinEachNodeTwo {

    public void connectIterative(TreeLinkNode root) {

        if(root==null) {
            return;
        }

        while (root!=null) {

            TreeLinkNode dummy = new TreeLinkNode(-1);
            TreeLinkNode tempHead = dummy;

            // 这里其实利用了上一层已经连起来了这个信息，还是比较巧妙的
            while (tempHead!=null) {
                if(root.left!=null) {
                    tempHead.next = root.left;
                    tempHead = tempHead.next;
                }

                if(root.right!=null) {
                    tempHead.next = root.right;
                    tempHead = tempHead.next;
                }

                root = root.next;
            }

            // 这里的dummy.next是本层的第一个Node，在下一次循环中就相当于上一层的信息了
            root = dummy.next;

        }

    }

}
