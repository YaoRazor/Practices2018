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

    //时间复杂度: O(N)使用的是 siftdown 之所以是 O(n) 是因为从第 N/2 个位置开始往下 siftdown，那么就有大约 N/4个数(倒数第二层)
    // 在 siftdown 中最多交换 1 次，N/8 个数最多交换 2 次(倒数第三层)，N/16 个数最多交换 3 次。 所以O(N/4*1+N/8*2+N/16*3+...+1*LogN)=O(N)
    public void heapify(int[] A) {
        // The starting point of i is the parent of last index
        // Given index n, its parent is floor((n-1)/2), see:
        // https://www.youtube.com/watch?v=fJORlbOGm9Y&list=PLTxllHdfUq4fMXqS6gCDWuWhiaRDVGsgu&index=3
        // 其实可以从A.length/2开始也行，就有可能多算一个，没有那么严格，这一题的重点是siftdown这个function
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
