package dropbox;


import java.util.BitSet;


public class DesignPhoneDirectory {
    private BitSet bitmap;
    private int    maxNumber;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) {
        this.maxNumber = maxNumbers;
        this.bitmap = new BitSet(maxNumbers*2-1);
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {

        int left = 0, right = maxNumber-1;
        int start = 0;
        if(bitmap.get(start)) return -1;
        while(left<right){
            int mid = (left+right)/2;
            if(!bitmap.get(start*2+1)){ //先从下半部分找
                start = start*2+1;
                right = mid;
            }
            else{
                start = start*2+2;
                left = mid+1;
            }
        }

        // left && right是要求的值，但是并不是index值本身
        setStatus(left, 0, 0, maxNumber-1);
        // print();
        return left;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number < 0 || number >= maxNumber) return false;
        return getStatus(number,0,0,maxNumber-1);
    }

    private boolean getStatus(int number, int current, int left, int right){
        if(bitmap.get(current)) return false; //这个是optimization
        if(left == right) return !bitmap.get(current);
        int mid = (left+right)/2;
        if(mid <number){
            return getStatus(number,current*2+2,mid+1,right);
        }else{
            return getStatus(number,current*2+1,left,mid);
        }

    }
//    private void flip(int number){
//        setStatus(number, 0, 0, maxNumber-1);
//    }
    private void setStatus(int number, int cur, int left, int right){
        if(left == right){
            bitmap.flip(cur);
            return ;
        }
        int mid = (left+right)/2;
        if(mid >= number){
            setStatus(number,cur*2+1,left,mid);
        }else{
            setStatus(number,cur*2+2,mid+1,right);
        }
        if(bitmap.get(cur*2+1) && bitmap.get(cur*2+2))
            bitmap.set(cur);
        else{
            bitmap.clear(cur);
        }
    }


    /** Recycle or release a number. */
    public void release(int number) {
        if(number>=maxNumber || number <0) return;
        if(!check(number)){
            setStatus(number, 0, 0, maxNumber-1);
        }
    }
}
