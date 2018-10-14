package quicksort;

public class QuickSort {



    public void quickSort(int[] nums) {

        if(nums==null || nums.length==0) {
            return;
        }

        quickSort(nums, 0, nums.length-1);


    }

    private void quickSort(int[] nums, int i, int j) {

        if(i>=j) {
            return;
        }

        int k = partition(nums, i, j);

        quickSort(nums, i, k-1);
        quickSort(nums, k+1, j);

    }



    // invariant is that to the right of the array, everything will be bigger than pivot
    public int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int left = l+1;
        int right = r;

        // For quick-select, this must be <= not <
        while(left<=right) {

            if(nums[left]<pivot) {
                left++;
            } else if(nums[right]>=pivot) {
                right--;
            } else {
                swap(nums, left, right);
            }

        }

        //必须要和右边换，和左边换有可能导致大的数被换到最左边
        swap(nums, l, right);

        return right;

    }


    private void swap(int[] nums, int i, int j) {

        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;

    }
}
