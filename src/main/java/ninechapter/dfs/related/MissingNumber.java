package ninechapter.dfs.related;

public class MissingNumber {

    // 高斯公式
    public int findMissing(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum+=num;
        }

        int n = nums.length;
        int expected = n*(n+1)/2;
        return expected-sum;
    }
}
