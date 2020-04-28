package ninechapter.dfs.required;


import java.util.*;

public class SplitString {

    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> ans = new ArrayList<>();
        LinkedList<String> cur = new LinkedList<>();
        if (s == null) return ans;
        dfs(s, 0, cur, ans);
        return ans;
    }

    private void dfs(String s, int index, LinkedList<String> cur, List<List<String>> results) {
        if (index == s.length()) {
            results.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 1; i <=2 && index + i <= s.length(); i++) {
            cur.add(s.substring(index, index + i));
            dfs(s, index + i, cur, results);
            cur.removeLast();
        }
    }
}
