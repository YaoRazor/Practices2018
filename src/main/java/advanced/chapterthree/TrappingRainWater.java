package advanced.chapterthree;

public class TrappingRainWater {

    // 这题的关键是以每一个木桶为单元来计算，然后如果右边大，就挪左边，左边大的话就挪右边，其实
    // 和LeetCode 11很相似，也是以木桶理论为基础的。这样操作到最后，对于每一个点来说，其实leftMax和rightMax
    // 的最小值就是这个点两边的最小值。具体可见:http://www.noteanddata.com/leetcode-42-Trapping-Rain-Water-java-solution-note-2.html
    public int trap(int[] height) {
        if(height==null || height.length<3) {
            return 0;
        }

        // leftMax represents the biggest value to the left of
        // current index including current index; rightMax is
        // similar
        int leftMax = height[0];
        int rightMax = height[height.length-1];

        int ans = 0;

        int left = 0;
        int right = height.length-1;

        // left will never be equal to right, because when left=right,
        // it will be the point that is biggest in this array
        while (left<right) {
            if(leftMax>=rightMax) {
                ans+=(rightMax - height[right]);
                right--;
                rightMax = Math.max(height[right], rightMax);
            } else {
                ans+=(leftMax - height[left]);
                left++;
                leftMax = Math.max(height[left], leftMax);
            }
        }

        return ans;
    }
}
