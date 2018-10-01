package dfs;

public class WordSearch {

    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || board[0].length==0) {
            return false;
        }

        visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {

                    if(dfs(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }


        return false;

    }

    private boolean dfs(char[][] board, String word, int pos, int i, int j) {
        if(pos>=word.length()) {
            return true;
        }

        if(i<0 || j<0 || i>=board.length || j>=board[i].length || visited[i][j]==true) {
            return false;
        }

        if(word.charAt(pos)==board[i][j]) {
            visited[i][j] = true;
            if (dfs(board, word, pos+1, i-1, j)
            || dfs(board, word, pos+1, i+1, j)
            || dfs(board, word, pos+1, i, j-1)
            || dfs(board, word, pos+1, i, j+1)) {

                return true;
            }
            visited[i][j] = false;
        }


        return false;
    }
}
