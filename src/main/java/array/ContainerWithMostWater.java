package array;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        if(height==null || height.length < 2) {
            return 0;
        }

        int l =0;
        int r = height.length-1;
        int ans = 0;

        while (l<r) {


            ans = Math.max(ans, (r-l+1)*Math.min(height[l], height[r]));

            if(height[l]> height[r]) {
                r--;
            } else {
                l++;
            }

        }

        return ans;


    }



}
