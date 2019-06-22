package unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

// This is a classic problem of union find!
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> fathers = new HashMap<>();
        Map<String, String> owners = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();

        // Intialize
        for(List<String> account: accounts) {
            String owner = account.get(0);

            for(int i=1; i<account.size(); i++) {
                fathers.put(account.get(i), account.get(i));
                owners.put(account.get(i), owner);
            }
        }

        // Union
        for(List<String> account: accounts) {
            // Attention! this is father, not the first element of the list
            String father = find(account.get(1), fathers);
            for(int i=2; i<account.size(); i++) {
                // Union two fathers, not two elements themselves
                fathers.put(find(account.get(i), fathers), father);
            }
        }

        for(List<String> account: accounts) {
            String father = find(account.get(1), fathers);
            if(!unions.containsKey(father)) {
                unions.put(father, new TreeSet<>());
            }

            for(int i=1; i<account.size(); i++) {
                unions.get(father).add(account.get(i));
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for(String father: unions.keySet()) {
            List<String> tmp = new ArrayList<>(unions.get(father));
            tmp.add(0, owners.get(father));
            ans.add(tmp);
        }

        return ans;
    }

    private String find(String child, Map<String, String> fathers) {
        String father = child;

        while(fathers.get(father)!=father) {
            father = fathers.get(father);
        }

        String cur = child;
        // optional path compression
        while(fathers.get(cur)!=father) {
            String tmp = fathers.get(cur);
            fathers.put(cur, father);
            cur = tmp;
        }

        return father;
    }
}
