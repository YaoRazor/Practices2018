package ninechapter.dp_topdown.optional;

import java.util.*;

public class WordSquare {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        if(words==null || words.length==0) {
            return ans;
        }

        LinkedList<String> cur = new LinkedList<>();

        dfs(ans, 0, words, cur);
        return ans;
    }


    private void dfs(List<List<String>> ans, int level, String[] words, LinkedList<String> cur) {
        if(level==words[0].length()) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        for(int i=0; i<words.length; i++) {
            if(isValid(cur, words[i])) {
                cur.add(words[i]);
                dfs(ans, level+1, words, cur);
                cur.removeLast();
            }
        }
    }

    private boolean isValid(LinkedList<String> cur, String tmp) {
        int n = cur.size();
        if(n==0) {
            return true;
        }

        for(int i=0; i<n; i++) {
            char c = tmp.charAt(i);
            if(c!=cur.get(i).charAt(n)) {
                return false;
            }
        }

        return true;
    }
}
