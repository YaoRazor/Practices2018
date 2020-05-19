package ninechapter.twopointers.optional;

public class KthSmallestNumbersInUnsortedArray {

    public int kthSmallest(int k, int[] nums) {
        return quickSelect(k, nums, 0, nums.length-1);
    }

    // key point one: function signature
    private int quickSelect(int k, int[] nums, int start, int end) {
        // Key point two: base case
        if(start==end) {
            return nums[start];
        }

        int pivot = nums[start];
        int left = start;

        for(int i=start+1; i<=end; i++) {
            if(nums[i]<pivot) {
                swap(nums, i, ++left);
            }
        }

        // Key point three: swap left and start
        swap(nums, start, left);

        if(left-start+1>=k) {
            // Key point four: the left array must include left, because otherwise,
            // All elements can be on the right side and cause infinite loop
            return quickSelect(k, nums, start, left);
        } else {
            return quickSelect(k-left+start-1, nums, left+1, end);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
