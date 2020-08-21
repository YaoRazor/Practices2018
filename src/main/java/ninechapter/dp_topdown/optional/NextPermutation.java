package ninechapter.dp_topdown.optional;

import java.util.Arrays;

// You get LintCode leaderboard for this problem
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int k = n-2;
        int l = n-1;
        for (k = n - 2; k >= 0; k--) {
            if (nums[k] < nums[k + 1]) {
                // 从右往左找，找到的是第一个比右边小的
                break;
            }
        }
        if (k < 0) {
            reverse(nums, 0);
        } else {
            // 从右往左找，找到的肯定是最小的比index k大的
            for (l = n - 1; l > k; l--) {
                if (nums[l] > nums[k]) {
                    break;
                }
            }

            swap(nums, k, l);
            reverse(nums,  k + 1);
        }

    }

    private void reverse(int[] nums, int start) {
        int end = nums.length-1;
        while(start<end) {
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

}
