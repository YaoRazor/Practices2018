package ninechapter.dfs.optional;

import java.util.*;

public class RemoveInvalidParentheses {
    private char[][] patterns = {{'(', ')'}, {')', '('}};

    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        if(s==null) {
            return ans;
        }

        dfs(ans, s, 0, 0, patterns[0]);
        return ans;
    }


    // DFS solution
    private void dfs(List<String> ans, String s, int lastI, int lastJ, char[] pattern) {
        int cnt = 0;
        int n = s.length();
        for(int i=lastI; i<n; i++) {
            char c = s.charAt(i);
            if(c==pattern[0]) {
                cnt++;
            } else if(c==pattern[1]){
                cnt--;
            }

            if(cnt>=0) {
                continue;
            }

            for(int j=lastJ; j<=i; j++) {
                if(s.charAt(j)==pattern[1] && (j==lastJ || s.charAt(j-1)!=s.charAt(j))) {
                    dfs(ans, s.substring(0, j)+s.substring(j+1), i, j, pattern);
                }
            }

            return;
        }

        s = new StringBuilder(s).reverse().toString();

        if(pattern[0]=='(') {
            dfs(ans, s, 0, 0, patterns[1]);
        } else {
            ans.add(s);
        }
    }


    // BFS solution is more intuitive
    public List<String> removeInvalidParenthesesBFS(String s) {
        List<String> ans = new ArrayList<>();

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean isFound = false;

        while(queue.size()>0) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                String tmp = queue.poll();
                if(isValid(tmp)) {
                    ans.add(tmp);
                    isFound = true;
                }

                if(isFound) {
                    continue;
                }

                List<String> neighbors = getNextStrings(tmp);
                for(String neighbor: neighbors) {
                    if(visited.contains(neighbor)) {
                        continue;
                    }

                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }


            if(ans.size()>0) {
                break;
            }

        }

        return ans;
    }

    private List<String> getNextStrings(String s) {
        List<String> ans = new ArrayList<String>();
        int sum_left = 0;
        int sum_right = 0;
        char remove = '(';
        // find which to remove
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                sum_left++;
            } else if (s.charAt(i) == ')') {
                sum_right++;
            }
        }
        if (sum_right > sum_left) {
            remove = ')';
        }
        // remove the ')'
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == remove) {
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                ans.add(sb.toString());
            }
        }
        return ans;
    }


    private boolean isValid(String s) {
        if(s==null || s.length()==0) {
            return true;
        }

        int cnt = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c!='(' && c!=')') {
                continue;
            }

            if(c=='(') {
                cnt++;
            } else {
                cnt--;
                if(cnt<0) {
                    return false;
                }
            }
        }

        return cnt==0;
    }
}
