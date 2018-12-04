package amazon;

import java.util.PriorityQueue;

public class KClosestPoints {

    class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
    }


    // 直接最小堆，然后取前k个
    public Point[] kClosest(Point[] points, Point origin, int k) {


        PriorityQueue<Point> pq = new PriorityQueue<>(

                (a, b) -> {

                    if(Math.pow(a.x-origin.x, 2) + Math.pow(a.y-origin.y, 2) == Math.pow(b.x-origin.x, 2) + Math.pow(b.y-origin.y, 2)) {
                        if(a.x==b.x) {
                            return a.y-b.y;
                        } else {
                            return a.x-b.x;
                        }
                    } else {
                        return (int)(Math.pow(a.x-origin.x, 2) + Math.pow(a.y-origin.y, 2)- Math.pow(b.x-origin.x, 2) - Math.pow(b.y-origin.y, 2));
                    }



                }
        );


        for(int i=0; i<points.length; i++) {

            pq.offer(points[i]);


        }

        Point[] ans = new Point[k];

        for(int i=0; i<k; i++) {
            ans[i] = pq.poll();
        }

        return ans;

        // write your code here
    }


}
