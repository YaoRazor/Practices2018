package ninechapter.bfs.optional;

import java.util.*;

public class SlidingPuzzleTwo {

    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minMoveStep(int[][] init_state, int[][] final_state) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>();

        String start = convertToString(init_state);
        String end = convertToString(final_state);

        queue.offer(start);
        set.add(start);

        int cnt = 0;

        while(queue.size()>0) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                String cur = queue.poll();
                if(cur.equals(end)) {
                    return cnt;
                }

                List<String> neighbors = getNextStrings(cur);

                for(String neighbor: neighbors) {
                    if(!set.contains(neighbor)) {
                        queue.offer(neighbor);
                        set.add(neighbor);
                    }
                }

            }

            cnt++;
        }

        return -1;
    }

    private List<String> getNextStrings(String cur) {
        List<String> ans = new ArrayList<>();
        int index = cur.indexOf('0');
        int x = index/3;
        int y = index%3;

        for(int[] dir: dirs) {
            int newX = x+dir[0];
            int newY = y+dir[1];
            if(!isValid(newX, newY)) {
                continue;
            }

            char[] tmp = cur.toCharArray();
            tmp[x*3+y] = tmp[newX*3+newY];
            tmp[newX*3+newY] = '0';
            ans.add(new String(tmp));
        }

        return ans;
    }

    private boolean isValid(int x, int y) {
        if(x<0 || x>=3 || y<0 || y>=3) {
            return false;
        }

        return true;
    }

    private String convertToString(int[][] state) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<state.length; i++) {
            for(int j=0; j<state[0].length; j++) {
                sb.append(state[i][j]);
            }
        }

        return sb.toString();
    }


}
