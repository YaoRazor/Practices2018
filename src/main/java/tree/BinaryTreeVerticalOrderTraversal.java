package tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import datastructures.TreeNode;

public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        LinkedList<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        queue.add(new java.util.AbstractMap.SimpleEntry<>(root, 0));

        int min = 0;
        int max = 0;
        while (queue.size() > 0) {

            Map.Entry<TreeNode, Integer> cur = queue.poll();

            TreeNode curNode = cur.getKey();
            Integer position = cur.getValue();

            if (map.containsKey(position)) {
                map.get(position).add(curNode.val);
            }
            else {
                map.put(position, new ArrayList<>());
                map.get(position).add(curNode.val);

            }

            if (curNode.left != null) {
                queue.add(new java.util.AbstractMap.SimpleEntry<>(curNode.left, position - 1));

                min = Math.min(min, position - 1);
            }


            if (curNode.right != null) {
                queue.add(new java.util.AbstractMap.SimpleEntry<>(curNode.right, position + 1));
                max = Math.max(max, position + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }
}
