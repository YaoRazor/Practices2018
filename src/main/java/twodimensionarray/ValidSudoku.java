package twodimensionarray;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudokuThreePass(char[][] board) {

        // row
        for(int i=0; i<9; i++) {
            if(!isBoardValid(board, i, i, 0, 8)) {
                return false;
            }
        }

        // column
        for(int i=0; i<9; i++) {
            if(!isBoardValid(board, 0, 8, i, i)) {
                return false;
            }
        }

        //Subbox
        for(int i=0; i<9; i=i+3) {
            for(int j=0; j<9; j=j+3) {
                if(!isBoardValid(board, i, i+2, j, j+2)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isBoardValid(char[][] board, int iMin, int iMax, int jMin, int jMax) {
        Set<Character> set = new HashSet<>();

        for(int i=iMin; i<=iMax; i++) {
            for(int j=jMin; j<=jMax; j++) {

                if('.'==board[i][j]) {
                    continue;
                }
                if(set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }

        return true;
    }
}
