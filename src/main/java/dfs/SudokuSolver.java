package dfs;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        isSolvable(board);
    }

    public boolean isSolvable(char[][] board) {

        for(int i=0; i<9; i++) {

            for(int j=0; j<9; j++) {

                if(board[i][j]=='.') {

                    for(char k='1'; k<='9'; k++) {

                        if(isValid(board, i, j, k)) {

                            board[i][j] = k;
                            if(isSolvable(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }

                    }

                    return false;


                }


            }

        }

        return true;


    }


    private boolean isValid(char[][] board, int row, int col, char c) {

        for(int i=0; i<9; i++) {

            if(board[row][i]==c || board[i][col]==c || board[(row/3)*3+i/3][(col/3)*3+i%3]==c) {

                return false;

            }

        }

        return true;

    }
}
