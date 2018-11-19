package tree;


import java.util.Stack;



public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
    public Node treeToDoublyList(Node root) {

        if(root==null) {
            return root;
        }

        Node cur = root;
        Stack<Node> stack = new Stack<>();
        Node first = null;
        Node last = null;

        while(cur!=null || !stack.isEmpty()) {

            while(cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }


            cur = stack.pop();

            if(first==null) {
                first = cur;
            }

            if(last!=null) {
                last.right = cur;
                cur.left = last;
            }

            last = cur;
            cur = cur.right;

        }

        first.left = last;
        last.right = first;
        return first;

    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
