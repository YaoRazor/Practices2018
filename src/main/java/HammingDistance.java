/**
 * Created by yawang on 2/27/18.
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {

        int xor = x^y;
        int res = 0;
        while(xor!=0) {
            res+= xor % 2;
            xor/=2;
        }
        return res;
    }


}
