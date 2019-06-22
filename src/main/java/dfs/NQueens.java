package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] cols = new int[n];
        Arrays.fill(cols, -1);
        backTrack(n, 0, cols, ans);
        return ans;
    }

    private void backTrack(int n, int cur, int[] cols, List<List<String>> ans) {
        if(cur==n) {
            ans.add(getString(cols));
            return;
        }

        for(int i=0; i<n; i++) {
            if(isValid(cols, cur, i)) {
                cols[cur] = i;
                backTrack(n, cur+1, cols, ans);
                // backtrack
                cols[cur] = -1;
            }

        }

    }

    private List<String> getString(int[] cols) {
        int n = cols.length;

        List<String> ans = new ArrayList<>();

        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++) {
                if(j!=cols[i]) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }

            ans.add(sb.toString());
        }

        return ans;
    }

    private boolean isValid(int[] cols, int cur, int index) {
        for(int i=0; i<cur; i++) {
            if(cols[i]==index || Math.abs(cols[i]-index)==Math.abs(cur-i)) {
                return false;
            }
        }

        return true;
    }

}
