package ninechapter.dfs.optional;

public class SudokuSolver {
    public void solveSudoku(int[][] board) {
        isSolvable(board);
    }

    private boolean isSolvable(int[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {

                if(board[i][j]!=0) {
                    continue;
                }

                for(int k=1; k<=9; k++) {
                    if(isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if(isSolvable(board)) {
                            return true;
                        }
                        // Do not forget backtracking here
                        board[i][j] = 0;
                    }
                }

                return false;
            }

        }

        return true;
    }

    private boolean isValid(int[][] board, int i, int j, int value) {
        for(int k=0; k<9; k++) {
            if(board[i][k]==value || board[k][j]==value) {
                return false;
            }

            // This is used to get the index within each subbox
            int x = k/3;
            int y = k%3;

            // i/3*3 will localte subbox horizontally
            // j/3*3 will locate subbox vertically
            if(board[i/3*3+x][j/3*3+y]==value) {
                return false;
            }
        }

        return true;
    }
}
