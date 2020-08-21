package companies.facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {

    private final int[][] DIRECTIONS = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    public int minKnightMoves(int x, int y) {
        // only calculate it in one quadrant
        x = Math.abs(x);
        y = Math.abs(y);

        // This is a special case for this problem particularly
        if(x==1 && y==1) {
            return 2;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});

        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int curX = cur[0];
                int curY = cur[1];
                if (curX == x && curY == y) {
                    return result;
                }

                for (int[] d : DIRECTIONS) {
                    int newX = curX + d[0];
                    int newY = curY + d[1];
                    if (!visited.contains(newX + "," + newY)  && newX >= 0 && newY >= 0) {
                        queue.add(new int[] {newX, newY});
                        visited.add(newX + "," + newY);
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
