package advanced.chaptertwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

// This is a classic problem of union find!
public class AccountsMerge {

    Map<String, String> map;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        if(accounts==null || accounts.size()==0) {
            return ans;
        }

        map = new HashMap<>();
        initializeGraph(accounts);
        connectVertice(accounts);

        Map<String, TreeSet<String>> tmp = new HashMap<>();

        for(String email: map.keySet()) {
            String key = find(email);

            if(tmp.containsKey(key)) {
                tmp.get(key).add(email.split("\\s+")[1]);
            } else {
                TreeSet<String> set = new TreeSet<>();
                String[] tmpString = key.split("\\s+");
                set.add(tmpString[0]);
                set.add(email.split("\\s+")[1]);
                tmp.put(key, set);
            }
        }

        for(String key: tmp.keySet()) {
            List<String> list = new ArrayList<>(tmp.get(key));
            ans.add(list);
        }

        return ans;
    }

    private String find(String x) {
        String ans =x;
        while(!map.get(ans).equals(ans)) {
            ans = map.get(ans);
        }

        while(!map.get(x).equals(ans)) {
            String tmp = map.get(x);
            map.put(x, ans);
            x = tmp;
        }

        return ans;
    }


    private void union(String x, String y) {
        String fx = find(x);
        String fy = find(y);

        if(!fx.equals(fy)) {
            map.put(fx, fy);
        }
    }

    private void connectVertice(List<List<String>> accounts) {
        for(List<String> account: accounts) {
            String name = account.get(0);
            for(int i=1; i<account.size()-1; i++) {
                // We can define extra data structure to store name of email alias
                // Current method is a little bit primitive
                union(name+" "+ account.get(i), name+" "+ account.get(i+1));
            }
        }
    }

    private void initializeGraph(List<List<String>> accounts) {
        for(List<String> account: accounts) {
            if(account.size()<=1) {
                continue;
            }

            String name = account.get(0);

            for(int i=1; i<account.size(); i++) {
                map.put(name+" "+ account.get(i), name+" "+account.get(i));
            }
        }
    }
}
