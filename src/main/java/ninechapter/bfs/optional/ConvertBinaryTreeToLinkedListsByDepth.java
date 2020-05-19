package ninechapter.bfs.optional;

import datastructures.ListNode;
import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ConvertBinaryTreeToLinkedListsByDepth {
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        ListNode dummyHead = new ListNode(-1);

        while(queue.size()>0) {
            int size = queue.size();

            ListNode head = dummyHead;
            head.next=null;

            for(int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                head.next = new ListNode(cur.val);
                head = head.next;
                if(cur.left!=null) {
                    queue.offer(cur.left);
                }

                if(cur.right!=null) {
                    queue.offer(cur.right);
                }
            }

            ans.add(dummyHead.next);
        }

        return ans;
    }
}
