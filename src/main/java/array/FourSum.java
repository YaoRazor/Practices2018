package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        if(nums==null || nums.length<4) {
            return ans;
        }

        Arrays.sort(nums);


        for(int i=0; i<nums.length-3; i++) {

            int sum = target-nums[i];

            List<List<Integer>> tmp = threeSum(nums, i+1, nums.length, sum);

            if(tmp.size()>0) {

                for(List<Integer> cur: tmp) {
                    List<Integer> four = new ArrayList<>();
                    four.add(nums[i]);
                    four.addAll(cur);
                    ans.add(four);
                }

            }

            while(i<nums.length-3 && nums[i]==nums[i+1]) {
                i++;
            }

        }


        return ans;

    }



    public List<List<Integer>> threeSum(int[] nums, int l, int r, int sum) {

        List<List<Integer>> ans = new ArrayList<>();



        for(int i=l; i<r-2; i++) {

            int target = sum-nums[i];

            int start = i+1;
            int end = r-1;

            while(start<end) {

                if(nums[start]+nums[end]==target) {

                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[start]);
                    cur.add(nums[end]);
                    ans.add(cur);
                    start++;
                    end--;

                    while(start<end && nums[start]==nums[start-1]) {
                        start++;
                    }

                    while(start<end && nums[end]==nums[end+1]) {
                        end--;
                    }

                } else

                if(nums[start]+nums[end]>=target) {
                    end--;
                } else {
                    start++;
                }

            }

            while(i<r-2 && nums[i]==nums[i+1]) {
                i++;
            }

        }

        return ans;

    }
}
