package linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if(s==null || s.length()<10) {
            return ans;
        }

        int i=0;
        Map<String, Integer> map = new HashMap<>();

        while(i+10<=s.length()) {

            String cur = s.substring(i, i+10);

            if(!map.containsKey(cur)) {
                map.put(cur, 1);
            } else {

                if(map.get(cur)==1) {
                    ans.add(cur);
                }
                map.put(cur, map.get(cur)+1);

            }
            i++;

        }

        return ans;
    }
}
