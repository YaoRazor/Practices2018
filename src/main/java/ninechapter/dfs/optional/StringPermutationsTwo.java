package ninechapter.dfs.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutationsTwo {

    public List<String> stringPermutation2(String str) {
        List<String> ans = new ArrayList<>();
        if(str==null) {
            return ans;
        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        boolean[] visited = new boolean[chars.length];
        dfs(ans, "", chars, visited);
        return ans;
    }

    private void dfs(List<String> ans, String cur, char[] chars,  boolean[] visited) {
        if(cur.length()==chars.length) {
            ans.add(cur);
            return;
        }

        for(int i=0; i<chars.length; i++) {
            if(visited[i]) {
                continue;
            }

            visited[i] = true;
            dfs(ans, cur+chars[i], chars, visited);
            visited[i] = false;

            while(i+1<chars.length && chars[i+1]==chars[i]) {
                i++;
            }
        }
    }
}
