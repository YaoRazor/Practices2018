package ninechapter.dp_topdown.optional;

import java.util.*;

public class PreviousPermutation {

    public List<Integer> previousPermuation(List<Integer> nums) {
        if(nums==null || nums.size()<2) {
            return nums;
        }
        int index = findExchangePostion(nums);
        System.out.println("index is "+ index);
        if(index==-1) {
            Collections.reverse(nums);
            return nums;
        }

        return exchangePostionAndResort(nums, index);
    }

    private List<Integer> exchangePostionAndResort(List<Integer> nums, int index) {
        int toExchage = index+1;
        int target = nums.get(index);

        for(int i= index+2; i<nums.size(); i++) {
            if(nums.get(i)<target && nums.get(i)>nums.get(toExchage)) {
                toExchage = i;
            }
        }

        int tmp = nums.get(index);
        nums.set(index, nums.get(toExchage));
        nums.set(toExchage, tmp);

        List<Integer> ans = nums.subList(0, index+1);
        List<Integer> tmpList = new ArrayList<>(nums.subList(index+1, nums.size()));
        Collections.sort(tmpList);
        Collections.reverse(tmpList);
        for(int i=0; i<tmpList.size(); i++) {
            ans.add(tmpList.get(i));
        }
        return ans;
    }

    private int findExchangePostion(List<Integer> nums) {
        for(int i=nums.size()-2; i>=0; i--) {
            if(nums.get(i)>nums.get(i+1)) {
                return i;
            }
        }

        return -1;
    }
}
