package binarysearch;

import java.util.Random;

public class RandomPickWithWeight {
    private int[] w;
    private int sum;
    Random random = new Random();

    public RandomPickWithWeight(int[] w) {
        this.w = new int[w.length];
        int sum = 0;
        for(int i=0; i<w.length; i++) {
            sum+=w[i];
            this.w[i] = sum;
        }

        this.sum = sum;
    }

    public int pickIndex() {
        int index = random.nextInt(this.sum);
        int start = 0;
        int end = this.w.length-1;

        while(start<end) {
            int mid = (start+end)/2;
            if(index>=this.w[mid]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
