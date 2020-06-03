package ninechapter.binarysearch.optional;

import java.util.ArrayDeque;
import java.util.Queue;


// We are using BFS to solve this problem, binary search can also be
// used.
public class SmallestRectangleEnclosingBlackPixels {

    int[][] dirs = {{1, 0}, {-1, 0}, {0,1},{0,-1}};

    class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean isValid(char[][] image, int x, int y){
        if(x>=0 && x<image.length && y>=0 && y<image[0].length && image[x][y]=='1') {
            return true;
        }

        return false;
    }

    public int minArea(char[][] image, int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[image.length][image[0].length];

        int minX = x;
        int maxX = x;

        int minY = y;
        int maxY = y;

        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while(queue.size()>0) {
            Point cur = queue.poll();

            for(int[] dir: dirs) {
                int dx = cur.x+dir[0];
                int dy = cur.y+dir[1];
                if(!isValid(image, dx, dy)) {
                    continue;
                }

                if(!visited[dx][dy]) {
                    minX = Math.min(dx, minX);
                    maxX = Math.max(dx, maxX);
                    minY = Math.min(dy, minY);
                    maxY = Math.max(dy, maxY);

                    visited[dx][dy] = true;
                    queue.offer(new Point(dx, dy));
                }
            }

        }

        return (maxX-minX+1)*(maxY-minY+1);
    }
}
