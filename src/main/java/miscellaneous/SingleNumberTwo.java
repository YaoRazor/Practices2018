package miscellaneous;

/**
 * Created by yawang on 5/1/18.
 */
public class SingleNumberTwo {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0; i<32; i++) {
            int sum = 0;

            for(int j: nums) {
                if(((j>>i)&1)==1) {
                    sum++;
                }
            }

            sum%=3;
            ans |= sum<<i;
        }

        return ans;

    }
}
