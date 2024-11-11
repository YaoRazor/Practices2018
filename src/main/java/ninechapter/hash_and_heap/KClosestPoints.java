package ninechapter.hash_and_heap;;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {

    // Time complexity is O(nlogk)
    public int[][] kClosestWithPriorityQueue(int[][] points, int k) {
        // Default pq is a min queue, using the comparator definition
        // changes it to a max queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2)-> {return p2[0]*p2[0]+p2[1]*p2[1]-p1[0]*p1[0]-p1[1]*p1[1];});

        for(int[] point: points) {
            pq.offer(point);
            if(pq.size()>k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];

        for(int i=k-1; i>=0; i--) {
            ans[i] = pq.poll();
        }

        return ans;
    }

    // This method is quick select, it is O(n) algorithm
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(k, points, 0, points.length-1);
        int[][] ans = new int[k][2];
        for(int i=0; i<k; i++) {
            ans[i] = points[i];
        }
        return ans;
    }

    // key point one: function signature
    private void quickSelect(int k, int[][] nums, int start, int end) {
        // Key point two: base case
        if(start==end) {
            return;
        }

        int[] pivot = nums[start];
        int left = start;

        for(int i=start+1; i<=end; i++) {
            if(compareTo(nums[i], pivot)) {
                swap(nums, i, ++left);
            }
        }

        swap(nums, start, left);

        if(left-start+1>=k) {
            quickSelect(k, nums, start, left);
        } else {
            quickSelect(k-left+start-1, nums, left+1, end);
        }
    }

    private boolean compareTo(int[] point1, int[] point2) {
        if(point1[0]*point1[0]+point1[1]*point1[1]-point2[0]*point2[0]-point2[1]*point2[1]<0) {
            return true;
        } else {
            return false;
        }
    }

    private void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }


}
