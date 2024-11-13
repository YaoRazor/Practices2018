package advanced.chaptertwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

// This is a classic problem of union find
public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }

        // grapqh set up
        for (List<String> a : acts) {
            for (int i = 1; i < a.size()-1; i++)
                union(a.get(i), a.get(i+1), parents);
        }

        // graph union
        for(List<String> a : acts) {
            String p = find(a.get(1), parents);
            if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                unions.get(p).add(a.get(i));
        }

        // aggregate the results
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            // This is the only place that we need the owner map to get the owner of the accounts
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }

    private String find(String x, Map<String, String> map) {
        String ans = x;
        while(!map.get(ans).equals(ans)) {
            ans = map.get(ans);
        }

        // path compression
        while(!x.equals(ans)) {
            String tmp = map.get(x);
            map.put(x, ans);
            x = tmp;
        }

        return ans;
    }


    private void union(String x, String y, Map<String, String> map) {
        String fx = find(x, map);
        String fy = find(y, map);

        map.put(fx, fy);
    }
}
