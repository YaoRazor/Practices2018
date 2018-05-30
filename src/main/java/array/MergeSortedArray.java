package array;


public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(nums1 == null || nums2 == null ) {
            return;
        }

        nums1 = null;
        System.out.print(nums1.length);

        int k = m+n-1;
        int i = m-1;
        int j = n-1;

        while(i>=0 && j>=0) {
            nums1[k--] = nums1[i]>=nums2[j]? nums1[i--]: nums2[j--];
        }

        while(j>=0) {
            nums1[k--] = nums2[j--];
        }

    }
}
