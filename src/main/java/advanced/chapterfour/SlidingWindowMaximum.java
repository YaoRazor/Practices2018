package advanced.chapterfour;

import java.util.*;


// o(n) time and O(k) memory
public class SlidingWindowMaximum {

    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if(nums.length<k) {
            return ans;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0; i<nums.length; i++) {
            while(!deque.isEmpty() && deque.peekLast()<nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(nums[i]);

            if(i>=k-1) {
                ans.add(deque.peekFirst());

                if(deque.peekFirst()==nums[i-k+1]) {
                    deque.pollFirst();
                }
            }
        }

        return ans;
    }
}
