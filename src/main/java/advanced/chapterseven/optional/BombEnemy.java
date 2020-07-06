package advanced.chapterseven.optional;

public class BombEnemy {

    // TC: O(nm)
    public int maxKilledEnemies(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0]==null || grid[0].length==0) {
            return 0;
        }

        int[][] tmp = new int[grid.length][grid[0].length];
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++) {
            int cur = 0;
            for(int j=0; j<m; j++) {
                if(grid[i][j]=='E') {
                    cur++;
                } else if(grid[i][j]=='W') {
                    cur = 0;
                }

                tmp[i][j]+=cur;
            }
        }

        for(int i=0; i<n; i++) {
            int cur = 0;
            for(int j=m-1; j>=0; j--) {
                if(grid[i][j]=='E') {
                    cur++;
                } else if(grid[i][j]=='W') {
                    cur = 0;
                }

                tmp[i][j]+=cur;
            }
        }


        for(int i=0; i<m; i++) {
            int cur = 0;
            for(int j=0; j<n; j++) {
                if(grid[j][i]=='E') {
                    cur++;
                } else if(grid[j][i]=='W') {
                    cur = 0;
                } else {
                    tmp[j][i]+=cur;
                }


            }
        }

        int ans = 0;

        for(int i=0; i<m; i++) {
            int cur = 0;
            for(int j=n-1; j>=0; j--) {
                if(grid[j][i]=='E') {
                    cur++;
                } else if(grid[j][i]=='W') {
                    cur = 0;
                } else {
                    tmp[j][i]+=cur;
                    ans = Math.max(ans, tmp[j][i]);
                }



            }
        }

        return ans;
    }
}
