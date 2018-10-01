package array;

public class RemoveDuplicatesFromSortedArrayTwo {
    public int removeDuplicates(int[] nums) {

        if(nums==null || nums.length==0) {
            return 0;
        }

        int cnt = 1;
        int index = -1;
        int pre = nums[0]-1;

        for(int i=0; i<nums.length; i++) {

            if(nums[i]!=pre) {
                cnt=1;
                pre = nums[i];
                nums[++index] = nums[i];
            } else {
                cnt++;
                if(cnt<3) {
                    nums[++index] = nums[i];
                }
            }

        }

        return index+1;

    }
}
