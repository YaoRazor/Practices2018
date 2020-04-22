package ninechapter.bfs;

import java.util.*;

public class SequenceReconstruction {

    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for(int[] seq: seqs) {
            for(int i=0; i<seq.length; i++) {
                int from = seq[i];
                if(from<1 || from>org.length) {
                    return false;
                }

                Set<Integer> set = graph.getOrDefault(from, new HashSet<>());
                if(i+1<seq.length) {
                    int to = seq[i+1];
                    set.add(to);
                }
                graph.put(from, set);
            }
        }

        for(Integer from: graph.keySet()) {
            for(Integer to: graph.get(from)) {
                inDegree.put(to, inDegree.getOrDefault(to, 0)+1);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i=1; i<=org.length; i++) {
            if(!inDegree.containsKey(i)) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            int size = queue.size();
            if(size>1) {
                return false;
            }

            int cur = queue.poll();
            result.add(cur);

            if(!graph.containsKey(cur)) {
                return false;
            }

            for(int i: graph.get(cur)) {
                inDegree.put(i, inDegree.get(i)-1);
                if(inDegree.get(i)==0) {
                    queue.offer(i);
                }
            }
        }

        if(result.size()!=org.length) {
            return false;
        }

        for(int i=0; i<org.length; i++) {
            if(result.get(i)!=org[i]) {
                return false;
            }
        }

        return true;
    }
}
