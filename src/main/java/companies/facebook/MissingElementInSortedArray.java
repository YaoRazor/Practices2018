package companies.facebook;

public class MissingElementInSortedArray {

    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int missingNum = nums[n-1]-nums[0]-(n-1);
        if(missingNum<k) {
            return nums[n-1] + k-missingNum;
        }

        int left = 0;
        int right = n-1;

        // because left=mid, therefore we have to use left+1<right
        // 而且这一题本质上是在搜索missing的number在哪两个数之间，
        // 最后定位在left+1==right这两个index之间
        while(left+1<right) {
            int mid = (left+right)/2;
            int missing = nums[mid]-nums[left]-(mid-left);
            if(missing>=k) {
                right = mid;
            } else {
                k-= missing;
                left = mid;
            }
        }

        // 最后定位在left+1==right这两个index之间，所以直接nums[left]+k就是答案
        return nums[left]+k;
    }
}
