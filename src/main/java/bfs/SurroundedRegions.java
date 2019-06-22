package bfs;

import java.util.ArrayDeque;
import java.util.Deque;

// BFS will be an intuitive solution, using DFS makes it easier, however, you will need to change
// the input value
public class SurroundedRegions {

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {

        if(board==null || board.length==0 || board[0]==null || board[0].length==0 || board.length==1) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        boolean[][] ans = new boolean[m][n];

        Deque<Point> deque= new ArrayDeque<>();

        for(int i=0; i<m; i=i+m-1) {
            for(int j=0; j<n; j++) {
                if('X'==board[i][j]) {
                    continue;
                }

                deque.add(new Point(i, j));
                ans[i][j] = true;

            }
        }

        System.out.println("second here");

        for(int i=0; i<n; i=i+n-1) {
            for(int j=1; j<m-1; j++) {
                if('X'==board[j][i]) {
                    continue;
                }
                deque.add(new Point(j, i));
                ans[j][i] = true;
            }
        }

        bfs(board, ans, deque);


        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if('O'==board[i][j] && !ans[i][j]) {
                    board[i][j] = 'X';
                }
            }

        }

    }

    class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void bfs(char[][] board, boolean[][] ans, Deque<Point> deque) {

        int m = board.length;
        int n = board[0].length;

        while(!deque.isEmpty()) {

            Point cur = deque.poll();

            for(int[] dir: dirs) {

                int newX = cur.x+dir[0];
                int newY = cur.y+dir[1];

                System.out.println("newX: "+newX + " newY: "+newY);

                if(newX<0 || newX>=m || newY<0 || newY>=n || 'X'==board[newX][newY] || ans[newX][newY]) {
                    continue;
                }

                deque.offer(new Point(newX, newY));
                ans[newX][newY] = true;

            }


        }

    }
}
