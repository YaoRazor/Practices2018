package airbnb;

import java.util.*;

public class PreferenceList {

    public List<Integer> getPreference(List<List<Integer>> preferences) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        List<Integer> ans = new ArrayList<>();

        if(preferences==null || preferences.size()==0) {
            return ans;
        }


        for(List<Integer> subList: preferences) {

            for(int i=0; i<subList.size(); i++) {

                Integer cur = subList.get(i);

                if(!indegree.containsKey(cur)) {
                    indegree.put(cur, 0);
                }

                if(!map.containsKey(cur)) {
                    map.put(cur, new HashSet<>());
                }

                if(i>0) {
                    Integer pre = subList.get(i-1);
                    indegree.put(cur, indegree.get(cur)+1);
                    map.get(pre).add(cur);
                }
            }
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for(Integer cur: indegree.keySet()) {
            if(indegree.get(cur) == 0) {
                deque.addLast(cur);
            }
        }


        while (!deque.isEmpty()) {

            Integer cur = deque.pollFirst();
            ans.add(cur);

            for(Integer preference: map.get(cur)) {

                indegree.put(preference, indegree.get(preference)-1);

                if(indegree.get(preference) == 0) {
                    deque.addLast(preference);
                }

            }

        }


        return ans;

    }
}
