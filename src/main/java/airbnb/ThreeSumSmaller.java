package airbnb;

import java.util.Arrays;

public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;

        for (int i = 0; i < nums.length - 2; i++) {

            int tmp = nums[i];
            int l = i + 1;
            int r = nums.length - 1;


            while (l < r) {

                int cur = nums[l] + nums[r] + tmp;

                if (cur < target) {
                    ans+= r-l;
                    l++;

                } if (cur >= target) {
                    r--;
                }

            }

        }

        return ans;
    }
}
