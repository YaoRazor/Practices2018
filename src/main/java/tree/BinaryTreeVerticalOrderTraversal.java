package tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datastructures.TreeNode;

// Level order traversal is used to solve this problem, we also need to store the
// col for each node in order to add it to the right list, the index doex not have
// to start from 0, it can start from negative numbers
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }

        Deque<Pair> deque = new ArrayDeque<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        deque.addLast(new Pair(root, 0));
        int min = 0;

        while(!deque.isEmpty()) {

            Pair cur = deque.pollFirst();
            TreeNode node = cur.node;
            int col = cur.col;

            if(!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }

            map.get(col).add(node.val);

            if(node.left!=null) {

                deque.addLast(new Pair(node.left, col-1));
                min = Math.min(min, col-1);
            }

            if(node.right!=null) {

                deque.addLast(new Pair(node.right, col+1));
            }


        }


        while(map.containsKey(min)) {
            ans.add(map.get(min++));
        }

        return ans;

    }


    class Pair {

        public TreeNode node;
        public int col;

        public Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}
