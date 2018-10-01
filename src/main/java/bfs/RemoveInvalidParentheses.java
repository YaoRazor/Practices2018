package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {


    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();

        if(s==null || s.length()==0) {
            return ans;
        }


        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();

        queue.add(s);
        boolean isFirst = false;

        while (!queue.isEmpty()) {
            String cur = queue.pollFirst();

            if(isValid(cur)) {

                ans.add(cur);
                isFirst = true;
            }

            if(isFirst) {
                continue;
            }


            for(int i=0; i< cur.length(); i++) {
                if(cur.charAt(i)!='(' && cur.charAt(i)!=')') {
                    continue;
                } else {
                    String t = cur.substring(0, i) + cur.substring(i+1);

                    if(!visited.contains(t)) {
                        queue.addLast(t);
                        visited.add(t);
                    }

                }


            }

        }

        return ans;


    }


    boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }

        return count == 0;
    }
}
