package twopointers;

public class ContainerWithMostWater {

    // O(n^2) solution is naive. If interviewer asks for O(n)
    // solution, that is strong hint for two pointer solution
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int ans = 0;

        while(left<right) {
            int height = Math.min(heights[left], heights[right]);

            ans = Math.max(ans, (right-left)*height);

            if(heights[left]>heights[right]) {
                right--;
            } else {
                left++;
            }
        }

        return ans;
    }

}
