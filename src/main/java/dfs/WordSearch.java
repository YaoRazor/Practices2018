package dfs;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(isExist(board, isVisited, word, 0, i, j)) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean isExist(char[][] board, boolean[][] isVisited, String word, int start, int i, int j) {
        if(start == word.length()) {
            return true;
        }

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || isVisited[i][j] || board[i][j]!=word.charAt(start)) {
            return false;
        }

        isVisited[i][j] = true;

        if(isExist(board, isVisited, word, start+1, i+1, j) ||
                isExist(board, isVisited, word, start+1, i-1, j) ||
                isExist(board, isVisited, word, start+1, i, j+1) ||
                isExist(board, isVisited, word, start+1, i, j-1) ) {
            return true;
        }

        isVisited[i][j] = false;
        return false;
    }
}
