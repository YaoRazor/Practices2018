package advanced.chapterfour;

public class Sqrt {
    public int sqrt(int x) {
        long start = 0;
        long end = x;

        while(start+1<end) {
            long mid = (start+end)/2;

            if(mid*mid<=(long)x) {
                start = mid;
            } else {
                end = mid-1;
            }
        }

        if(end*end<=(long)x) {
            return (int)end;
        } else {
            return (int)start;
        }
    }
}
