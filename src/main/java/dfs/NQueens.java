package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {



    // NQuuens本质上其实是一个一维DFS，只不过在buildString和isValid上稍微需要实现一下
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        if(n<=0) {
            return ans;
        }

        LinkedList<String> cur = new LinkedList<>();

        int[] columnNumberForLine = new int[n];
        for(int i=0; i<n; i++) {
            columnNumberForLine[i] = -1;
        }

        dfs(ans, cur, columnNumberForLine, n);

        return ans;

    }


    private void dfs(List<List<String>> ans, LinkedList<String> cur, int[] columnNumberForLine, int n) {

        if(cur.size()==n) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        int level = cur.size();

        for(int i=0; i<n; i++) {

            columnNumberForLine[level] = i;

            if(isValid(columnNumberForLine, level, i)) {

                cur.add(buildString(n, i));
                dfs(ans, cur, columnNumberForLine, n);
                cur.removeLast();

            }

        }

    }


    private boolean isValid(int[] columnNumberForLine, int level, int column) {

        for(int i=0; i<level ; i++) {

            if((Math.abs(columnNumberForLine[i]-column) == Math.abs(i-level)) || columnNumberForLine[i]==column) {
                return false;
            }

        }

        return true;

    }


    private String buildString(int n, int k) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {

            if(i==k) {
                sb.append('Q');
            } else {
                sb.append('.');
            }

        }

        return sb.toString();
    }

}
