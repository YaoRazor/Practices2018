package ninechapter.twopointers;

public class SortIntegersTwo {
    public void sortIntegers2WithQuickSort(int[] A) {
        if(A==null || A.length<=2) {
            return;
        }

        quickSort(A, 0, A.length-1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if(start>=end) {
            return;
        }

        int pivot = nums[start];
        int cur = start;

        for(int i=start; i<=end; i++) {
            if(nums[i]<pivot) {
                swap(nums, ++cur, i);
            }
        }

        // Make sure that pivot is in the middle, so that
        // Every recursion, there is at least one element
        // that has been sorted so that we would have stack overflow
        swap(nums, start, cur);

        quickSort(nums, start, cur-1);
        quickSort(nums, cur+1, end);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public void sortIntegers2WithMergeSort(int[] A) {
        if(A==null || A.length<=2) {
            return;
        }

        int[] tmp = new int[A.length];
        mergeSort(A, 0, A.length-1, tmp);
    }

    private void mergeSort(int[] nums, int start, int end, int[] tmp) {
        if(start>=end) {
            return;
        }

        int mid = (start+end)/2;
        mergeSort(nums, start, mid, tmp);
        mergeSort(nums, mid+1, end, tmp);
        merge(nums, start, end, tmp);
    }

    private void merge(int[] nums, int start, int end, int[] tmp) {
        int mid = (start+end)/2;
        int left = start;
        int right = mid+1;
        int index = start;

        while(left<=mid && right<=end) {

            if(nums[left]<=nums[right]) {
                tmp[index++] = nums[left++];
            } else {
                tmp[index++] = nums[right++];
            }
        }

        while(left<=mid) {
            tmp[index++] = nums[left++];
        }

        while(right<=end) {
            tmp[index++] = nums[right++];
        }

        for(int i=start; i<=end; i++) {
            nums[i] = tmp[i];
        }
    }
}
