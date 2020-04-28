package ninechapter.twopointers;

public class KthLargestElement {
    public int kthLargestElement(int n, int[] nums) {
        return quickSelect(nums, 0, nums.length-1, nums.length-n+1);
    }

    private int quickSelect(int[] nums, int start, int end, int n) {
        if(start==end) {
            return nums[start];
        }

        int pivot = nums[start];
        int cur = start;
        for(int i=start+1; i<=end; i++) {
            if(nums[i]<pivot) {
                swap(nums, ++cur, i);
            }
        }

        swap(nums, cur, start);

        if(cur-start+1>=n) {
            return quickSelect(nums, start, cur, n);
        } else { //(cur-start+1<n){
            return quickSelect(nums, cur+1, end, n-(cur-start+1));
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
