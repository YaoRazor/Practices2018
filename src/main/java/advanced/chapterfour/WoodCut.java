package advanced.chapterfour;

public class WoodCut {

    // TC: O(n log Len), where Len is the len length of the wood.
    public int woodCut(int[] L, int k) {
        if(L==null || L.length==0) {
            return 0;
        }

        int start = 0;
        int end = 0;
        long sum = 0;

        for(int l: L) {
            end = Math.max(l, end);
            sum+=l;
        }

        if(sum<k) {
            return 0;
        }

        while(start+1<end) {
            int mid = start+(end-start)/2;
            if(totalPieces(L, mid)>=k) {
                start = mid;
            } else {
                end = mid-1;
            }
        }

        if(totalPieces(L, end)>=k) {
            return end;
        } else {
            return start;
        }

    }

    private int totalPieces(int[] L, int piece) {
        int cnt = 0;

        for(int l: L) {
            cnt+=l/piece;
        }

        return cnt;
    }
}
