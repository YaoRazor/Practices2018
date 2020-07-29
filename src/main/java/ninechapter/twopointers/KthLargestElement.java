package ninechapter.twopointers;


// Compare this with KthSmallestNumbersInUnsortedArray
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
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

        if(end-right+1>=k) {
            return quickSelect(nums, right, end, k);
        } else {
            return quickSelect(nums, start, right-1, k-(end-right+1));
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
