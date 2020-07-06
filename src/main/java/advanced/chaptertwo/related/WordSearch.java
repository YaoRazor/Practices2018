package advanced.chaptertwo.related;

public class WordSearch {

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i=0; i< n; i++) {
            for(int j=0; j<m; j++) {
                if(dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if(index==word.length()) {
            return true;
        }

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j] || board[i][j]!=word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        for(int[] dir: dirs) {
            int nx = i+dir[0];
            int ny = j+dir[1];
            if(dfs(board, word, index+1, nx, ny, visited)) {
                return true;
            }
        }

        visited[i][j] = false;
        return false;
    }
}
