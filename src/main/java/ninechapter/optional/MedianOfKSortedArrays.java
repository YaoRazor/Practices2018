package ninechapter.optional;

public class MedianOfKSortedArrays {

    // 这一题求出的结果其实不一定是k array里的数，所以其实有点尬，
    // 更多的把这道题当成训练二分法的练习，不一定要追求AC
    public double findMedian(int[][] nums) {
        int n = getTotal(nums);
        if(n==0) {
            return 0;
        }

        if(n%2==1) {
            return findKth(nums, n/2+1);
        } else {
            return findKth(nums, n/2)/2.0+findKth(nums, n/2+1)/2.0;
        }
    }


    private int getTotal(int[][] nums) {
        int ans = 0;
        for(int[] num: nums) {
            if(num!=null) {
                ans+=num.length;
            }
        }

        return ans;
    }

    private int findKth(int[][] nums, int k) {
        int start = 0;
        int end = Integer.MAX_VALUE;

        // Find the first(smallest) number with k numbers smaller or equal than it
        // The standard ans from ninechapter is to find the last(biggest) number x that >= k numbers are >= x.
        while(start+1<end) {
            int mid = (end-start)/2+start;

            if(getLTE(nums, mid)>=k) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        if(getLTE(nums, start)>=k) {
            return start;
        }

        return end;
    }


    private int getLTE(int[][] nums, int val) {
        int ans = 0;
        for(int[] num: nums) {
            ans+=getLTE(num, val);
        }
        return ans;
    }

    private int getLTE(int[] nums, int val) {
        if(nums==null || nums.length==0) {
            return 0;
        }

        int start = 0;
        int end = nums.length-1;


        while(start+1<end) {
            int mid = (start+end)/2;
            if(nums[mid]>val) {
                end = mid-1;
            } else {
                start = mid;
            }
        }

        int ans = 0;

        if(nums[end]<=val) {
            ans = end+1;
        } else if(nums[start]<=val){
            ans = start+1;
        }

        return ans;
    }
}
