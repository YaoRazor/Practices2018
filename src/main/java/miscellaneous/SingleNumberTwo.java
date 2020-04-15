package miscellaneous;

public class SingleNumberTwo {
    // The solution of single number two can also be used to solve the problem of single number one
    public int singleNumber(int[] nums) {
        int ans = 0;

        for(int i=0; i<32; i++) {
            int sum = 0;
            for(int num: nums) {
                sum += (num >>i) & 1;
            }

            ans |= (sum%3)<<i;
        }

        return ans;
    }
}
