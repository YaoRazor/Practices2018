package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {

        List<String> ans = new ArrayList<>();

        if(cpdomains==null || cpdomains.length==0) {
            return ans;
        }

        Map<String, Integer> map = new HashMap<>();

        for(String cur: cpdomains) {
            String[] numberAndString = cur.split("\\s+");
            int cnt = Integer.parseInt(numberAndString[0]);
            String frag = numberAndString[1];
            String[] tmp = frag.split("\\.");
            String key = "";

            for(int i=tmp.length-1; i>=0; i--) {

                key= i==tmp.length-1? tmp[i]+key: tmp[i]+"."+key;

                map.put(key, map.getOrDefault(key, 0)+cnt);

            }

        }

        for(String key: map.keySet()) {
            ans.add(map.get(key)+" "+key);
        }

        return ans;

    }
}
