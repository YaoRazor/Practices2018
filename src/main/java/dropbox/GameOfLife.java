package dropbox;

public class GameOfLife {
        int[][] dir = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};

        public void gameOfLife(int[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    int live = 0;
                    for (int[] d : dir) {
                        if (d[0] + i < 0 || d[0] + i >= board.length || d[1] + j < 0 || d[1] + j >= board[0].length)
                            continue;
                        if (board[d[0] + i][d[1] + j] == 1 || board[d[0] + i][d[1] + j] == 2)
                            live++;
                    }
                    if (board[i][j] == 0 && live == 3)
                        board[i][j] = 3;
                    if (board[i][j] == 1 && (live < 2 || live > 3))
                        board[i][j] = 2;
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    board[i][j] %= 2;
                }
            }
        }


//    int[][] transformation = new int[][]
//            {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

//    public void gameOfLife(int[][] board) {
//
//        int[][] newBoard = new int[board.length][board[0].length];
//
//        getNextState(board, newBoard);
//
//        for(int i=0; i<board.length; i++) {
//            for(int j=0; j<board[0].length; j++) {
//                board[i][j] = newBoard[i][j];
//            }
//        }
//
//    }
//
//    private void getNextState(int[][] board, int[][] newBoard) {
//
//        for(int i=0; i<board.length; i++) {
//            for(int j=0; j<board[0].length; j++) {
//                int cnt = 0;
//                for(int k=0; k<transformation.length; k++) {
//
//                    int tx = i+transformation[k][0];
//                    int ty = j+transformation[k][1];
//
//                    if(tx<0 || tx>=board.length || ty<0 || ty>=board[0].length) {
//                        continue;
//                    }
//
//                    if(board[tx][ty]==1) {
//                        cnt++;
//                    }
//                }
//
//                if(board[i][j]==1) {
//
//                    if(cnt<2) {
//                        newBoard[i][j] = 0;
//                    } else if(cnt==2 || cnt==3) {
//                        newBoard[i][j] = 1;
//                    } else {
//                        newBoard[i][j] = 0;
//                    }
//
//                } else {
//                    if(cnt==3) {
//                        newBoard[i][j] = 1;
//                    }
//                }
//
//            }
//        }
//
//
//    }
}
