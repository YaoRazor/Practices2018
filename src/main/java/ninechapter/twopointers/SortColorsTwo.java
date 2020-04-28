package ninechapter.twopointers;

public class SortColorsTwo {
    public void sortColors2(int[] A, int k) {
        if(A==null || A.length<=2 || k==1) {
            return;
        }

        quickSort(A, 0, A.length-1, 1, k);
    }

    private void quickSort(int[] nums, int start, int end, int from, int to) {
        // Because there is an extra condition that when from==to, we will return
        // directly, so that there is no stack overflow issue
        if(start>=end || from==to) {
            return;
        }

        int pivot = (from+to)/2+1;
        int cur = start-1;

        for(int i=start; i<=end; i++) {
            if(nums[i]<pivot) {
                swap(nums, ++cur, i);
            }
        }

        quickSort(nums, start, cur, 1, (from+to)/2);
        quickSort(nums, cur+1, end, pivot, to);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
