package ninechapter.dfs.required;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        if(n<=0) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        dfs(ans, cur, n);
        return buildString(ans, n);
    }

    private boolean isValid(int col, List<Integer> cur) {

        int position = cur.size();

        for(int row=0; row<position; row++) {

            int column = cur.get(row);

            if(col==column) {
                return false;
            }

            if(row+column==position+col) {
                return false;
            }

            if(position-col==row-column) {
                return false;
            }
        }

        return true;
    }


    private void dfs(List<List<Integer>> ans, LinkedList<Integer> cur, int n) {
        if(cur.size()==n) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        for(int i=0; i<n; i++) {
            if(!isValid(i, cur)) {
                continue;
            }

            cur.add(i);
            dfs(ans, cur, n);
            cur.removeLast();
        }

    }

    private List<List<String>> buildString(List<List<Integer>> input, int n) {
        List<List<String>> ans = new ArrayList<>();

        for(int i=0; i<input.size(); i++) {
            List<String> cur = new ArrayList<>();
            for(int j=0; j<n; j++) {
                int tmp = input.get(i).get(j);
                StringBuilder sb = new StringBuilder();

                for(int k=0; k<n; k++) {

                    if(k==tmp) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }

                }

                cur.add(sb.toString());
            }
            ans.add(cur);
        }

        return ans;
    }

}
