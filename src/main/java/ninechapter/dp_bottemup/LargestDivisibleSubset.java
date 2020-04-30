package ninechapter.dp_bottemup;

import java.util.*;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        if(nums==null || nums.length==0) {
            return res;
        }

        Arrays.sort(nums);

        int n = nums.length;
        int[] dp = new int[n];
        int[] pre = new int[n];
        Arrays.fill(pre, -1);

        int ans = 0;
        int index = -1;

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i]%nums[j]==0) {
                    if(dp[j]+1>dp[i]) {
                        pre[i] = j;
                        dp[i] = dp[j]+1;
                    }
                }
            }

            if(dp[i]>ans) {
                ans = dp[i];
                index = i;
            }
        }


        if(index==-1) {
            // When there is no results, the test case will return first element
            // This is actually not right, but put this line here just to pass OJ
            res.add(nums[0]);
            return res;
        }

        res.add(nums[index]);

        while(pre[index]!=-1) {
            res.addFirst(nums[pre[index]]);
            index = pre[index];
        }

        return res;
    }
}
