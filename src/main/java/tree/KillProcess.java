package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {



        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i=0; i<ppid.size(); i++) {

            Integer cur = ppid.get(i);

            if(map.containsKey(cur)) {

                Set<Integer> set = map.get(cur);
                set.add(pid.get(i));

                map.put(cur, set);

            } else {

                Set<Integer> set = new HashSet<>();
                set.add(pid.get(i));
                map.put(cur, set);
            }
        }

        Deque<Integer> deque = new ArrayDeque<>();

        deque.addLast(kill);

        List<Integer> ans = new ArrayList<>();

        while(!deque.isEmpty()) {
            Integer cur = deque.pollFirst();
            ans.add(cur);

            if(map.containsKey(cur)) {
                deque.addAll(map.get(cur));
            }
        }


        return ans;

    }
}
