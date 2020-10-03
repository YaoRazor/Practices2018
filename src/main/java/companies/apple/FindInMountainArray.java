package companies.apple;

public class FindInMountainArray {

    interface MountainArray {
        int get(int index);
        int length();
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length()-1;

        while(start<end) {
            int mid = (start+end)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        int peak = start;
        start = 0;
        end = peak;

        while(start<end) {
            int mid = (start+end)/2;
            if(mountainArr.get(mid)<target) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        if(mountainArr.get(start)==target) {
            return start;
        }

        start = peak;
        end = mountainArr.length()-1;

        while(start<end) {
            int mid = (start+end)/2;
            if(mountainArr.get(mid)>target) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        if(mountainArr.get(start)==target) {
            return start;
        }

        return -1;
    }
}
