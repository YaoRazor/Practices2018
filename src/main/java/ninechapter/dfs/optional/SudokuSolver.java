package ninechapter.dfs.optional;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solvaable(board, 0, 0);
    }

    private boolean solvaable(char[][] board, int row, int col) {
        // small optimization to always start with the next possible position
        for(int i=row; i<9; i++, col=0) {
            for(int j=col; j<9; j++) {
                if(board[i][j]!='.') {
                    continue;
                }

                for(char num='1'; num<='9'; num++)   {
                    if(!isValid(board, i, j, num)) {
                        continue;
                    }

                    board[i][j] = num;
                    if(solvaable(board, i, j+1)) {
                        return true;
                    }
                    board[i][j] = '.';
                }

                return false;
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char num) {
        for(int k=0; k<9; k++) {
            if(board[k][j]==num || board[i][k]==num) {
                return false;
            }

            if(board[i/3*3+k/3][j/3*3+k%3]==num) {
                return false;
            }
        }

        return true;
    }
}
