package dp;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }

        int[] values = new int[10001];
        for(int num: nums) {
            values[num]+=num;
        }

        int skip = 0, take = 0;

        for(int i=0; i<values.length; i++) {

            int takei= skip+ values[i];
            int skipi= Math.max(take, skip);
            skip = skipi;
            take = takei;

        }

        return Math.max(skip, take);

    }
}
