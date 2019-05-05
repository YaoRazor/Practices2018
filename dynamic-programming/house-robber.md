# House Robber

It is fairly easy to come up with the below solution

```text
    public int rob(int[] nums) {
        
        if(nums==null || nums.length==0) {
            return 0;
        }
        
        int[] dp = new int[nums.length+1];
        
        dp[0] = 0;
        dp[1] = nums[0];
        
        for(int i=2; i<=nums.length; i++) {
            
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
            
        }
        
        return dp[nums.length]; 
    }
```

After second look, you will find that to compute the result for index i, you only need the previous two results, which means you don't need to keep an array, you only need to keep two variables. Therefore, we have the updated solution:

```text
    public int rob(int[] nums) {
        
        if(nums==null || nums.length==0) {
            return 0;
        }
        
        int[] dp = new int[nums.length+1];
        
        int pre = 0;
        int cur = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            
            int tmp = cur;
            cur = Math.max(pre+nums[i], cur);
            pre = tmp;     
        }
        
        return cur; 
    }
```

The MaxSubarray problem is similar:

```text
    public int maxSubArray(int[] nums) {
        
        if(nums==null || nums.length==0) {
            return 0;
        }
        
        int pre = nums[0];   
        int ans = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            pre = Math.max(pre+nums[i], nums[i]);
            ans = Math.max(pre, ans);
        }
        
        return ans;   
    }
```

 

