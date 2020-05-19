package ninechapter.dfs.optional;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(ans, "", 0, s, 0);
        return ans;
    }

    private void dfs(List<String> ans, String cur, int start, String s, int level) {
        if(start==s.length() && level==4) {
            ans.add(cur.substring(0, cur.length()-1));
            return;
        }

        for(int i=1; i<=3 && start+i<=s.length(); i++) {
            if(i!=1 && s.charAt(start)=='0') {
                return;
            }

            String tmp = s.substring(start, start+i);
            if(Integer.parseInt(tmp)>255) {
                break;
            }

            dfs(ans, cur+tmp+".", start+i, s, level+1);
        }
    }
}
