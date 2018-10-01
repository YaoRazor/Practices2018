package twodimensionarray;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        int ans = 0;

        if(grid==null || grid.length==0) {
            return 0;
        }


        for(int i=0; i<grid.length; i++) {

            for(int j=0; j<grid[0].length; j++) {

                if(grid[i][j]==1) {
                    ans+=4;
                    if(i<grid.length-1 && grid[i+1][j]==1) {
                        ans-=2;
                    }

                    if(j<grid[0].length-1 && grid[i][j+1]==1) {
                        ans-=2;
                    }
                }

            }

        }

        return ans;

    }

}
