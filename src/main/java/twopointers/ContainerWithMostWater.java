package twopointers;

public class ContainerWithMostWater {

    // 两根指针，移动木桶的短板
    public int maxArea(int[] height) {
        int i=0;
        int j = height.length-1;
        int ans = 0;

        while(i<j) {
            ans = Math.max(ans, (j-i)*Math.min(height[i], height[j]));

            if(height[i]<height[j]) {
                i++;
                while(i<j && height[i]<height[i-1]) {
                    i++;
                }
            } else {
                j--;
                while(i<j && height[j]<height[j+1]) {
                    j--;
                }
            }
        }

        return ans;
    }

}
