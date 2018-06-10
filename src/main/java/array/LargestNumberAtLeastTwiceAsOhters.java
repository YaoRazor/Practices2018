package array;


// As access time of an array is O(1), probably it is better to store the index
// instead of the value itself
public class LargestNumberAtLeastTwiceAsOhters {
    public int dominantIndex(int[] nums) {

        if(nums==null || nums.length==0) {
            return -1;
        }

        if(nums.length==1) {
            return 0;
        }

        int biggest = nums[0]>nums[1]? 0:1;
        int second = nums[0]>nums[1]? 1:0;

        for(int i=0; i<nums.length; i++) {
            int cur = nums[i];
            if(cur>nums[biggest]) {
                second = biggest;
                biggest = i;
            } else if(cur<nums[biggest] && cur>nums[second]) {
                second = i;
            }
        }

        if(nums[biggest]>=2*nums[second]) {
            return biggest;
        } else {
            return -1;
        }
    }
}
