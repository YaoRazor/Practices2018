package bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {

        int row = board.length;
        int column = board[0].length;

        String start = "";
        String goal = "123450";

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                start += board[i][j];
            }
        }

        if(start==goal) {
            return 0;
        }

        int ans = 0;

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Set<String> visited = new HashSet<>();
        visited.add(start);

        Deque<String> queque = new ArrayDeque<>();
        queque.addLast(start);

        while (!queque.isEmpty()) {

            ans++;
            int size = queque.size();

            while (size-- > 0) {

                String cur = queque.pollFirst();

                int position = cur.indexOf('0');
                int y = position / column;
                int x = position % column;


                for (int i = 0; i < 4; i++) {

                    int tx = x + dirs[i][0];
                    int ty = y + dirs[i][y];

                    if (tx < 0 || ty < 0 || tx >= column || ty >= row) {
                        continue;
                    }

                    int newPostion = tx + ty * column;

                    String newString = swap(cur, position, newPostion);

                    if (newString.equals(goal)) {
                        return ans;
                    }

                    if (visited.contains(newString)) {
                        continue;
                    }
                    else {
                        visited.add(newString);
                        queque.addLast(newString);
                    }

                }

            }


        }

        return -1;
    }


    static String swap(String str, int i, int j)
    {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
