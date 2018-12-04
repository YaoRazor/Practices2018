package binarysearch;

import java.util.Random;

public class RandomPickWithWeight {
    int[] preSum;

    public RandomPickWithWeight(int[] w) {

        preSum = new int[w.length];
        preSum[0] = w[0];

        for(int i=1; i<w.length; i++) {
            preSum[i] = preSum[i-1]+w[i];
        }

    }

    public int pickIndex() {

        int index = new Random().nextInt(preSum[preSum.length-1])+1;

        int left = 0;
        int right = preSum.length-1;

        while(left<right) {
            int mid = (left+right)/2;

            if(index==preSum[mid]) {
                return mid;
            } else if(preSum[mid]<index) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
