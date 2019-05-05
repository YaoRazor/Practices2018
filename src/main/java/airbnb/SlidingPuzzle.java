package airbnb;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

// 对于BFS来说，如果是单一方向的有向图，那么可以不记录已经访问的点，但如果有环，那么需要考虑环的问题
public class SlidingPuzzle {

    public boolean slidingPuzzle(int[][] board) {


        StringBuilder sb = new StringBuilder();
        int n = board.length;
        int m = board[0].length;

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sb.append(board[i][j]);
            }
        }

        String start = sb.toString();

        // 只要修改target就行了，这个solution是unified的
        String target = "123456780";

        if(target.equals(start)) {
            return true;
        }

        int step = 0;

        Deque<String> deque = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        deque.addLast(start);
        visited.add(start);

        while (!deque.isEmpty()) {

            int size = deque.size();

            for(int i=0; i<size; i++) {

                String cur = deque.pollFirst();

                if(target.equals(cur)) {
                    return true;
                }

                int index = cur.indexOf('0');

                int x = index/m;
                int y = index%m;

                for(int[] dir: dirs) {

                    int dx = x + dir[0];
                    int dy = y + dir[1];

                    if(checkBound(dx, dy, n, m)) {
                        continue;
                    }

                    int newPosition = dx*m + dy;

                    String newString = swap(cur, index, newPosition);

                    if(!visited.contains(newString)) {

                        visited.add(newString);
                        deque.addLast(newString);
                    }
                }


            }
            step++;

        }

        return false;

    }



    private boolean checkBound(int i, int j, int n, int m) {

        if(i<0 || i>=n || j<0 || j>=m) {
            return true;
        } else {
            return false;
        }
    }


    private String swap(String str, int original, int newPosition) {
        StringBuilder sb = new StringBuilder(str);

        char swapped = sb.charAt(newPosition);
        sb.setCharAt(original, swapped);
        sb.setCharAt(newPosition, '0');
        return sb.toString();
    }
}
