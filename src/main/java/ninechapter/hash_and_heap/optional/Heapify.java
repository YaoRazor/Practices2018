package ninechapter.hash_and_heap.optional;

public class Heapify {

    private void siftdown(int[] A, int i) {
        while(i*2+1<A.length) {
            int smallestIndex = i;
            if(A[i*2+1]<A[i]) {
                smallestIndex = i*2+1;
            }

            if(i*2+2<A.length && A[i*2+2]<A[smallestIndex]) {
                smallestIndex = i*2+2;
            }

            if(i==smallestIndex) {
                break;
            }

            swap(A, i, smallestIndex);

            i = smallestIndex;
        }
    }

    public void heapify(int[] A) {
        // The starting point of i is the parent of last index
        // Given index n, its parent is floor((n-1)/2), see:
        // https://www.youtube.com/watch?v=fJORlbOGm9Y&list=PLTxllHdfUq4fMXqS6gCDWuWhiaRDVGsgu&index=3
        for(int i=A.length/2-1; i>=0; i--) {
            // This is basically to adjust each element from second last level
            siftdown(A, i);
        }
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
