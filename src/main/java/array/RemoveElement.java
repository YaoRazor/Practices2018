package array;

public class RemoveElement {
   public int removeElement(int[] nums, int val) {
       if(nums==null || nums.length==0) {
           return 0;
       }

       int i=0;
       int j = nums.length;

       while(i<j) {
           if(nums[i]==val) {
               swap(nums, i, --j);
           } else {
               i++;
           }
       }

       return i;
   }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
