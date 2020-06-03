package advanced.chapterfour;

public class CopyBooks {

    // TC: O(log(range)*n): range is sum-max, n is the number of elements in pages
    public int copyBooks(int[] pages, int k) {
        int start = 0;
        int end = 0;

        for(int page: pages) {
            start = Math.max(start, page);
            end +=page;
        }

        while(start+1<end) {
            int mid = (start+end)/2;
            if(copierNeeded(pages, mid)>k) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        if(copierNeeded(pages, start)<=k) {
            return start;
        } else {
            return end;
        }
    }

    private int copierNeeded(int[] pages, int upperBound) {
        int cnt = 0;
        int sum = 0;

        for(int page: pages) {
            sum+=page;
            if(sum>upperBound) {
                cnt++;
                sum = page;
            }
        }

        cnt++;
        return cnt;
    }
}
