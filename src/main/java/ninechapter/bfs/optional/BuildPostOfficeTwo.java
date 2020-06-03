package ninechapter.bfs.optional;

import java.util.*;

//总结:
//很好的一道bfs经典例题，其突破口在于逆向思维。我如果把每个点到所有house的距离和都算一遍然后比较出最小距离和，假设这个矩阵有n个0,那我相当于要做n次bfs. 效率太低。
//
//所以要优化，因为一般空地(0)较多, house(1)较少, 那我们倒过来想，从House出发，对于每个House, 看看他周围能到达的所有空地，根据bfs能计算出到house的距离，这样如果House的数量为m, 做m次bfs即可， 每次bfs把当前空地到当前house的距离和上一次bfs计算出的当前点到之前house的距离累加起来即可。
//
//但是这里还需要开一个二维数组reach, 来记录当前点能到达地的house数量。这个也可以在上一段中的bfs实现。
//
//这样最终bfs全部完成后，初始化一个min_dist = 0, 两个for loop来检查当前点的reach[i][j]是否等于house数，如果等于，就更新min_dist = min(min_dist, dist[i][j]) 即可。
public class BuildPostOfficeTwo {

    public int shortestDistance(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0]==null || grid[0].length==0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        // Change one source multiple destination problem to
        // Multiple source, single des

        int[][] cnt = new int[n][m], sumDist = new int[n][m];
        int totalHouse = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==1) {
                    totalHouse++;
                    bfs(grid, cnt, sumDist, i, j);
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(cnt[i][j]==totalHouse) {
                    ans = Math.min(sumDist[i][j], ans);
                }
            }
        }

        return ans==Integer.MAX_VALUE? -1: ans;
    }

    class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] dirs = new int[][]{{0,1}, {0, -1}, {1,0}, {-1, 0}};

    private void bfs(int[][] grid, int[][] cnt, int[][] sumDist, int i, int j) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j));
        visited[i][j] = true;
        int dist = 0;

        while(queue.size()>0) {
            int size = queue.size();

            for(int k=0; k<size; k++) {
                Point cur = queue.poll();
                if(grid[cur.x][cur.y]==0) {
                    cnt[cur.x][cur.y]++;
                    sumDist[cur.x][cur.y]+=dist;
                }

                for(int[] dir: dirs) {
                    int x = cur.x+dir[0];
                    int y = cur.y+dir[1];

                    if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]!=0 || visited[x][y]) {
                        continue;
                    }

                    queue.offer(new Point(x, y));
                    visited[x][y] = true;
                }
            }

            dist++;
        }

    }
}
