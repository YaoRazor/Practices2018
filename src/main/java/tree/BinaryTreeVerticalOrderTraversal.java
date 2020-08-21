package tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import datastructures.TreeNode;


public class BinaryTreeVerticalOrderTraversal {
    class Element {
        int value;
        int level;
        Element(int value, int level) {
            this.value = value;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Element>> map = new HashMap<>();
        if(root==null) {
            return new ArrayList<>();
        }
        dfs(map, root, 0, 0);
        int min = 0;
        int max = 0;

        List<List<Integer>> ans = new ArrayList<>();
        for(int key: map.keySet()) {
            min = Math.min(min, key);
            max = Math.max(max, key);
        }

        for(int i=min; i<=max; i++) {
            if(map.containsKey(i)) {
                Collections.sort(map.get(i), (e1, e2)-> {
                    if(e1.level==e2.level) {
                        return e1.value - e2.value;
                    } else {
                        return e1.level - e2.level;
                    }
                });

                List<Integer> tmp = map.get(i).stream().map(e->e.value).collect(Collectors.toList());;
                ans.add(tmp);
            }
        }

        return ans;
    }

    private void dfs(Map<Integer, List<Element>> map, TreeNode root, int level, int order) {
        if(root==null) {
            return;
        }

        map.putIfAbsent(order, new ArrayList<>());
        map.get(order).add(new Element(root.val, level));
        dfs(map, root.left, level+1, order-1);
        dfs(map, root.right, level+1, order+1);
    }
}
