package dfs;

public class NQueensTwo {
    int ans = 0;
    public int totalNQueens(int n) {

        if(n<=0) {
            return ans;
        }

        int[] columnNumberForLine = new int[n];

        dfs(columnNumberForLine, 0);

        return ans;

    }


    private void dfs(int[] columnNumberForLine, int level) {

        if(level==columnNumberForLine.length) {
            ans++;
            return;
        }

        for(int i=0; i<columnNumberForLine.length; i++) {
            columnNumberForLine[level] = i;

            if(isValid(columnNumberForLine, level, i)) {
                dfs(columnNumberForLine, level+1);

            }

        }

    }


    private boolean isValid(int[] columnNumberForLine, int level, int column) {

        // Attention: i only needs to be smaller than level, no need to be smaller than columnNumberForLine.length
        for(int i=0; i<level ; i++) {

            if((Math.abs(columnNumberForLine[i]-column) == Math.abs(i-level)) || columnNumberForLine[i]==column) {
                return false;
            }

        }

        return true;

    }
}
