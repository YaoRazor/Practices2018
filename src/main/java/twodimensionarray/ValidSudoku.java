package twodimensionarray;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<9; i++) {
            if (!isParticallyValid(board,i,0,i+1,9)) return false;
            if (!isParticallyValid(board,0,i,9,i+1)) return false;
        }
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if (!isParticallyValid(board,i*3,j*3,i*3+3,j*3+3)) return false;
            }
        }
        return true;
    }
    private boolean isParticallyValid(char[][] board, int x1, int y1,int x2,int y2){
        Set singleSet = new HashSet();
        for (int i= x1; i<x2; i++){
            for (int j=y1;j<y2; j++){
                if (board[i][j]!='.') if(!singleSet.add(board[i][j])) return false;
            }
        }
        return true;
    }
}
