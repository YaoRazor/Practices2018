package dropbox;

import java.util.BitSet;

public class AllocateId {

    BitSet bitSet = new BitSet(10);

    private boolean getStatus(int number, int cur, int left, int right) {

        if(bitSet.get(cur)) {
            return false;
        }

        if(left==right) {
            return bitSet.get(cur);
        }

        int mid = (left+right)/2;

        if(mid<number) {

            return getStatus(number, cur*2+2, mid, right);

        } else {
            return getStatus(number, cur*2+1, left, mid);
        }




    }


    private void setStatus(int number, int cur, int left, int right) {

        if(left==right) {
            bitSet.flip(cur);
        }


        int mid = (left + right)/2;
        if(mid<number) {

            setStatus(number, cur*2+2, mid, right);

        } else {
            setStatus(number, cur*2+1, left, mid);
        }


        if(bitSet.get(cur*2+1) && bitSet.get(cur*2+2)){
            bitSet.set(cur);
        } else {
            bitSet.clear(cur);
        }




    }
}
