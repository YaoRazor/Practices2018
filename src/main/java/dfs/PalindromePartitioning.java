package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {


    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        if(s==null || s.length()==0) {
            return ans;
        }


        LinkedList<String> cur = new LinkedList<>();

        dfs(ans, cur, 0, s);

        return ans;

    }


    private void dfs(List<List<String>> ans, LinkedList<String> cur, int pos, String s) {

        if(pos==s.length()) {
            ans.add(new LinkedList<>(cur));
            return;
        }


        for(int i=pos; i< s.length(); i++) {

            if(isPalindrome(s, pos, i)) {
               cur.add(s.substring(pos, i+1));
               dfs(ans, cur, i+1, s);
               cur.removeLast();
            }
        }

    }



    private boolean isPalindrome(String s, int start, int end) {

        while (start<end) {
            if(s.charAt(start)!=s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

}
