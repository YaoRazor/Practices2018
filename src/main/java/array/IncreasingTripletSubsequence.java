package array;


// This solution is a little bit hacky, actually there
// are other solutions that are more intuitive. See
// This https://www.cnblogs.com/grandyang/p/5194599.html
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MAX_VALUE;

        for(int num: nums) {
            if(num<=m1) {
                m1 = num;
            } else if(num<=m2) {
                m2 = num;
            } else {
                return true;
            }
        }

        return false;
    }

}
