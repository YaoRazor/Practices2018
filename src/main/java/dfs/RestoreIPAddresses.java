package dfs;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {

        List<String> ans = new ArrayList<>();

        if(s==null || s.length()==0) {
            return ans;
        }

        String curString ="";

        dfs(ans, curString, 0, s, 0);

        return ans;

    }


    private void dfs(List<String> ans, String cur, int start, String s, int cnt) {

        if(cnt==4) {
            ans.add(cur);
            return;
        }

        if(cnt==3) {
            if(isValid(s.substring(start))) {
                dfs(ans, cur+s.substring(start), s.length(), s, 4);
            }
            return;
        }


        for(int i = start+1; i<=s.length() && i<=start+3; i++) {

            String subString = s.substring(start, i);

            if(isValid(subString)) {
                dfs(ans, cur+subString+'.', i, s, cnt+1);
            }

        }

    }



    private boolean isValid(String s) {

        if(s==null || s.length()==0 || s.length()>3) {
            return false;
        }

        if(s.charAt(0)=='0') {
            return s.equals("0");
        }

        int value = Integer.parseInt(s);
        if(value>255 || value<0) {
            return false;
        }

        return true;

    }
}
