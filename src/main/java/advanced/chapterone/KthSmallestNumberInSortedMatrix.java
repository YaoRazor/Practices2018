package advanced.chapterone;

import java.util.Comparator;
import java.util.PriorityQueue;

//虽然是每pop一个加两个， 但是沿着两个方向走都有上限(m, n),所以最大不会超过2* max(m, n)
//如果matrix可以变动，可以优化空间复杂度，原位记录访问与否
//基本上就是用heap做了bfs. TC: O(klogN), N=Math.max(m,n);
public class KthSmallestNumberInSortedMatrix {

    class Point {
        int x, y, val;
        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int[][] dirs = {{0, 1}, {1, 0}};
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.val));
        pq.offer(new Point(0, 0, matrix[0][0]));
        visited[0][0] = true;

        Point cur = null;

        while(k>0) {
            k--;
            cur = pq.poll();

            for(int[] dir: dirs) {
                int x = dir[0]+cur.x;
                int y = dir[1]+cur.y;

                if(x>=matrix.length || y>=matrix[0].length || visited[x][y]) {
                    continue;
                }

                pq.offer(new Point(x, y, matrix[x][y]));
                visited[x][y] = true;
            }
        }

        return cur.val;
    }
}
