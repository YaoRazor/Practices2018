package ninechapter.tree;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class ClosestBinarySearchTreeValueTwo {

    // This way helps you understand more of the tree operations
    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> lower = getStack(root, target);
        Stack<TreeNode> upper = new Stack<>();
        upper.addAll(lower);

        if(target<lower.peek().val) {
            moveLower(lower);

        } else {
            moveUpper(upper);
        }
        if(!lower.isEmpty()) {
            System.out.println(lower.peek().val);
        }
        if(!upper.isEmpty()) {
            System.out.println(upper.peek().val);
        }

        for(int i=0; i<k; i++) {
            if(lower.isEmpty() || !upper.isEmpty() &&
                    (Math.abs(lower.peek().val-target)>Math.abs(upper.peek().val-target))) {
                ans.add(upper.peek().val);
                moveUpper(upper);
            } else {
                ans.add(lower.peek().val);
                moveLower(lower);
            }
        }

        return ans;
    }


    private Stack<TreeNode> getStack(TreeNode cur, double target) {
        Stack<TreeNode> stack = new Stack<>();

        while(cur!=null) {
            stack.push(cur);
            if(cur.val<target) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        return stack;
    }


    private void moveLower(Stack<TreeNode> stack) {

        TreeNode cur = stack.peek();

        if(cur.left!=null) {
            cur = cur.left;
            while(cur!=null) {
                stack.push(cur);
                cur = cur.right;
            }
        } else {

            cur = stack.pop();

            while(!stack.isEmpty() && stack.peek().left==cur) {
                cur = stack.pop();
            }

        }
    }

    public void moveUpper(Stack<TreeNode> stack) {
        TreeNode node = stack.peek();
        if (node.right == null) {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
            return;
        }

        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }


    class TargetComparator implements Comparator<Integer> {

        double target;

        public TargetComparator(double target) {
            this.target = target;
        }

        @Override
        public int compare(Integer i1, Integer i2) {

            double diff = Math.abs(target-i2)-Math.abs(target-i1);

            if(diff>0) {
                return 1;
            } else if (diff==0) {
                return 0;
            } else {
                return -1;
            }

        }
    }

    // This is more straight-forward way of solving this problem
    public List<Integer> closestKValuesUskingHeap(TreeNode root, double target, int k) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new TargetComparator(target));
        TreeNode cur = root;

        while(cur!=null || !stack.isEmpty()) {
            // When the node is not null, we need to find its
            // leftmost TreeNode
            while(cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }
            // Everytime the TreeNode was poped from the stack,
            // it means all nodes in the left subtree has been
            // processed.
            cur = stack.pop();
            // We process the middle node
            pq.offer(cur.val);
            if(pq.size()>k) {
                pq.poll();
            }
            // We start to process the right sub tree
            cur = cur.right;
        }

        while(!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        Collections.sort(ans);
        return ans;
    }


}
