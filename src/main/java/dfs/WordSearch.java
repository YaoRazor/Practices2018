package dfs;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || board[0]==null || board[0].length==0) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    boolean dfs(char[][] board, String word, int k, int i, int j, Set<Integer> visited)  {
        if(k==word.length()) {
            return true;
        }

        if(i<0 || i>=board.length || j<0 || j>=board[0].length ||
                visited.contains(i*board[0].length+j) || word.charAt(k)!=board[i][j]) {
            return false;
        }

        int index = i*board[0].length+j;
        visited.add(index);

        for(int[] dir: dirs) {
            int x= i+dir[0];
            int y = j+dir[1];
            if(dfs(board, word, k+1, x, y, visited)) {
                return true;
            }
        }

        visited.remove(index);
        return false;
    }
}
