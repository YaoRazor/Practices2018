package array;

// The key point is to copy from end to start
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i>=0 && j>=0) {
            if(nums1[i]>nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        if(j>=0) {

            while(j>=0) {
                nums1[j] = nums2[j];
                j--;
            }

        }
    }
}
