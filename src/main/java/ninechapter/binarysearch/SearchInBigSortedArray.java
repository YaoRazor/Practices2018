package ninechapter.binarysearch;

public class SearchInBigSortedArray {

    // dummy implementation
    class ArrayReader {
        public int  get(int k) {
            return 0;
        }
    }

    public int searchBigSortedArray(ArrayReader reader, int target) {
        int end = findIndexThatIsNotLessThanTarget(reader, target);

        int start = 0;

        while(start+1<end) {
            int mid = start+(end-start)/2;

            if(reader.get(mid)<target) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        if(reader.get(start)==target) {
            return start;
        } else if(reader.get(end)==target) {
            return end;
        }

        return -1;
    }

    private int findIndexThatIsNotLessThanTarget(ArrayReader reader, int target) {
        int start = 1;

        while(reader.get(start)<target) {
            start*=2;
        }

        return start;
    }
}
