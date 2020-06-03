package advanced.chapterfour;

import java.util.Arrays;

public class CopyBooksTwo {

    // This problem is very similar to copy books one
    // TC is O(log(range)*k), k is the length of times
    public int copyBooksII(int n, int[] times) {
        Arrays.sort(times);

        int start = times[0];
        int end = n*times[0];

        while(start+1<end) {
            int mid = (start+end)/2;
            if(isDoable(n, times, mid)) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        if(isDoable(n, times, start)) {
            return start;
        } else {
            return end;
        }
    }

    private boolean isDoable(int n, int[] times, int upperBound) {
        for(int i=0; i<times.length; i++) {
            if(times[i]>upperBound || n<=0) {
                break;
            }

            int cnt = upperBound/times[i];
            n-=cnt;
        }

        return n<=0;
    }
}
