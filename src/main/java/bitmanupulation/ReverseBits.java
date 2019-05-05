package bitmanupulation;


public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i=0; i<32; i++) {
            result = result<<1;
            int currentBit = 1&n;
            result|=currentBit;
            n = n>>1;
        }
        return result;
    }


    //这里是按照四位一组，如果想要再优化速度，可以八位一组，那样的话需要的表就会大一些
    public int tableLookUp(int n) {
        int[] tb = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        int ret = 0;
        int mask = 15;


        for(int i=0; i<8; i++) {
            int tmp = tb[(n&mask)];
            tmp = tmp<<(7-i)*4;
            ret|=tmp;
            n = n>>4;
        }

        return ret;
    }
}
