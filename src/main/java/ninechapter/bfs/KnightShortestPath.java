package ninechapter.bfs;

import ninechapter.Point;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class KnightShortestPath {

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if(grid==null || grid.length==0){
            return 0;
        }

        Queue<Point> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        int n = grid[0].length;

        queue.offer(source);
        // If the equals function of Point class has been overridden, we can use
        // Set<Point> to check whether this node has been visited or not
        visited.add(source.x*n+source.y);

        int[][] delta = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2},{2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        int distance = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {

                Point cur = queue.poll();
                if(cur.x==destination.x && cur.y==destination.y) {
                    return distance;
                }

                for(int[] tmp: delta) {

                    int dx = cur.x+tmp[0];
                    int dy = cur.y+tmp[1];

                    if(dx<0 || dx>=grid.length || dy<0 || dy>=n || grid[dx][dy] || visited.contains(dx*n+dy)) {
                        continue;
                    }

                    // System.out.println("cur.x is: "+cur.x+" cur.y is "+cur.y+" dx is "+dx+" dy is "+dy);

                    queue.offer(new Point(dx, dy));
                    visited.add(dx*n+dy);
                }

            }

            distance++;
        }

        return -1;
    }
}
