package advanced.chapterone;

import java.util.PriorityQueue;
import java.util.Queue;


// Time O(k * log(min(n, m)))
// Space O(min(n, m))
public class KthSmallestSumInTwoSortedArrays {

    class Pos {
        int i, j;
        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        int[] L1 = A.length <= B.length ? A : B;
        int[] L2 = A.length <= B.length ? B : A;
        int n = L1.length, m = L2.length;
        Queue<Pos> minHeap = new PriorityQueue<>((o1, o2) -> (L1[o1.i] + L2[o1.j]) - (L1[o2.i] + L2[o2.j]));

        for (int i = 0; i < n; i++) {
            minHeap.offer(new Pos(i, 0));
        }

        for (int i = 0; i < k - 1; i++) {
            Pos top = minHeap.poll();
            if (top.j + 1 < m) {
                top.j++;
                minHeap.offer(top);
            }
        }

        Pos top = minHeap.poll();
        return L1[top.i] + L2[top.j];
    }
}
