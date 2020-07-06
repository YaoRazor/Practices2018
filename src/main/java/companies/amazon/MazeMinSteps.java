package companies.amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class MazeMinSteps {


//    static class Point {
//        public int x, y;
//        public int cost;
//
//        public Point(int x, int y, int cost) {
//            this.x = x;
//            this.y = y;
//            this.cost = cost;
//        }
//    }
//
//    public int minSteps(int[][] maze, int dx, int dy) {
//        Point point = bfs(maze, dx, dy);
//        return (point == null) ? -1 : point.cost;
//    }
//
//    private Point bfs(int[][] maze, int dx, int dy) {
//        final int m = maze.length, n = maze[0].length;
//        final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
//        boolean[][] visited = new boolean[m][n]; // false
//
//        Queue<Point> que = new LinkedList<>();
//        que.offer(new Point(0, 0, 0));
//
//        while (!que.isEmpty()) {
//            Point curPoint = que.poll();
//            for (int[] d : dirs) {
//                int r = curPoint.x + d[0], c = curPoint.y + d[1];
//                int cost = curPoint.cost;
//                if (0 <= r && r < m && 0 <= c && c < n && !visited[r][c]
//                        && maze[r][c] == 0) {
//                    Point nextPoint = new Point(r, c, cost + 1);
//
//                    if (r == dx && c == dy) { // Destination point
//                        return nextPoint;
//                    }
//
//                    que.offer(nextPoint);
//                    visited[r][c] = true;
//                }
//            }
//        }
//
//        return null;
//    }


    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }



    public int minSteps(int[][] maze, int dx, int dy) {
        return bfs(maze, dx, dy);
    }


    private int bfs(int[][] maze, int dx, int dy) {


        Deque<Point> deque = new ArrayDeque<>();

        deque.addLast(new Point(0, 0));


        int n = maze.length;
        int m = maze[0].length;

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        int[][] dirs = new int[][] {{-1,0}, {1, 0}, {0, -1}, {0, 1}};

        int distance = 0;

        while (!deque.isEmpty()) {

            int size = deque.size(); // the size of current level;

            for(int i=0; i<size; i++) {

                Point cur = deque.pollFirst();

                for(int[] dir: dirs) {

                    int newX = cur.x + dir[0];
                    int newY = cur.y + dir[1];

                    if(newX>=0 && newX<n && newY>=0 && newY< m && maze[newX][newY]==0 && !visited[newX][newY]) {


                        if(newX==dx && newY==dy) {
                            return distance + 1;
                        }


                        Point newPoint = new Point(newX, newY);
                        deque.addLast(newPoint);
                        visited[newX][newY] = true;

                    }

                }

            }

            distance++;


        }

        return -1;


    }
}
