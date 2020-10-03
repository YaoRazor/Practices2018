package ninechapter.hash_and_heap;;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {

    class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
    }

    public Point[] kClosest(Point[] points, Point origin, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(new PointComparator(origin));
        for(Point point: points) {
            pq.offer(point);
            if(pq.size()>k) {
                pq.poll();
            }
        }

        Point[] ret = new Point[k];
        while (!pq.isEmpty())
            ret[--k] = pq.poll();
        return ret;
    }

    class PointComparator implements Comparator<Point> {
        private Point o;
        public PointComparator(Point origin) {
            this.o = origin;
        }

        @Override
        public int compare(Point p1, Point p2) {
            if( Math.pow(p2.x-o.x, 2) + Math.pow(p2.y-o.y, 2)-Math.pow(p1.x-o.x, 2) - Math.pow(p1.y-o.y, 2) ==0) {
                if(p1.x==p2.x) {
                    return p2.y-p1.y;
                } else {
                    return p2.x-p1.x;
                }
            } else {
                return (int)(Math.pow(p2.x-o.x, 2) + Math.pow(p2.y-o.y, 2)-Math.pow(p1.x-o.x, 2) - Math.pow(p1.y-o.y, 2));
            }
        }
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
