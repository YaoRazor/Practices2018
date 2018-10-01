package array;

public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {


            // This is for branch pruning, can be removed
            if (nums[i] == 0) {
                continue;
            }

            int j=i;
            int k = i;
            int startValue = nums[i];

            // This condition is used to make sure that the loop is on the same direction
            while(startValue* nums[getIndex(k, nums)]>0 && nums[getIndex(getIndex(k, nums), nums)]*startValue>0) {

                j = getIndex(j, nums);
                k = getIndex(getIndex(k, nums), nums);

                if(j==k) {

                    // Make sure it is not one element loop
                    if(getIndex(j, nums)==j) {
                        break;
                    }
                    return true;
                }

            }


            // Below is for branch pruning, can be removed
            j = i;
            int val = nums[i];
            while (nums[j] * val > 0) {
                int next = getIndex(j, nums);
                nums[j] = 0;
                j = next;
            }


        }
        return false;
    }

    public int getIndex(int i, int[] nums) {
        int n = nums.length;
        return i + nums[i] >= 0? (i + nums[i]) % n: n + ((i + nums[i]) % n);
    }
}
