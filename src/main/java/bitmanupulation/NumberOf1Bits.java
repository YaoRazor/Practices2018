package bitmanupulation;


public class NumberOf1Bits {
    public int hammingWeight(int n) {

        int cnt = 0;

        for(int i=0; i<32; i++) {

            int tmp = (n>>i)&1;
            if(tmp==1) {
                cnt++;
            }
        }

        return cnt;
    }
}
