package advanced.chapterseven;

import java.util.*;

// TC: O(N), SC: O(1)
public class ContinuousSubarraySumTwo {

    class Point{
        int left, right, sum;
        Point(int left, int right, int sum) {
            this.left = left;
            this.right = right;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "left is "+left+" right is "+right+" sum is "+sum+"\n";
        }
    }

    public List<Integer> continuousSubarraySumII(int[] A) {
        List<Integer> ans = new ArrayList<>();
        if(A==null || A.length==0) {
            return ans;
        }

        int total = 0;
        for(int num: A) {
            total+=num;
        }

        Point positive = continuousSubarraySum(A, 1);
        Point negative = continuousSubarraySum(A, -1);

        if(positive.sum>=total+negative.sum || negative.right-negative.left+1==A.length) {
            ans.add(positive.left);
            ans.add(positive.right);
        } else {
            ans.add(negative.right+1);
            ans.add(negative.left-1);
        }

        return ans;
    }


    public Point continuousSubarraySum(int[] A, int flag) {
        Point point = new Point(0, 0, A[0]);
        if(A==null || A.length==0) {
            return null;
        }
        int minSum = 0;
        int pre = -1;
        int curMax = Integer.MIN_VALUE;
        int curSum = 0;


        for(int i=0; i<A.length; i++) {
            curSum+=A[i]*flag;
            if(curSum-minSum>curMax) {
                point.left = pre+1;
                point.right = i;
                curMax = curSum-minSum;
                point.sum = curMax;
            }

            if(curSum<minSum) {
                minSum = curSum;
                pre = i;
            }
        }

        return point;
    }
}
