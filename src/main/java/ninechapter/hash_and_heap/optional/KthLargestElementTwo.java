package ninechapter.hash_and_heap.optional;

public class KthLargestElementTwo {

    // This is exactly the same as Kth Largest Element One, but
    // we are using a different way of partitioning
    public int kthLargestElement2(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length-1);
        // write your code here
    }

    private int quickSelect(int[] nums, int k, int start, int end) {
        if(start==end) {
            return nums[start];
        }

        int pivot = nums[end];
        int right = end;

        for(int i=end-1; i>=start; i--) {
            if(nums[i]>pivot) {
                swap(nums, i, --right);
            }
        }

        swap(nums, right, end);

        if(k<=end-right+1) {
            return quickSelect(nums, k, right, end);
        } else {
            return quickSelect(nums, k-end+right-1, start, right-1);
        }
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
