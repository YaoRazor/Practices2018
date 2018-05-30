import java.util.HashMap;

import datastructures.ListNode;


public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int j = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                int tmp = nums[j+1];
                nums[j+1] = nums[i];
                nums[i] = tmp;
                j++;
            }
        }


        HashMap<ListNode, ListNode> map = new HashMap<>();
    }
}
