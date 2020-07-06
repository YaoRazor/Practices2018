package advanced.chaptersix.optional;

// Also can be considered as BackPackVI
public class CombinationSumIV {


    public int backPackVI(int[] nums, int target) {
        int[] sum = new int[target + 1];
        sum[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num: nums) {
                if (i >= num) {
                    sum[i] += sum[i - num];
                }
            }
        }
        return sum[target];
    }
}
