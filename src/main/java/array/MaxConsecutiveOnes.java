package array;


public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {

        if(nums==null || nums.length==0) {
            return 0;
        }


        Boolean isConsecutive = false;
        int maxCount = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++) {

            if(nums[i]==1) {
                isConsecutive = true;
                count++;
            } else {

                if(isConsecutive) {
                    isConsecutive = false;
                    maxCount = Math.max(count, maxCount);
                    count = 0;
                }
            }

        }

        return maxCount;


    }
}
