package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict= new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int ans = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                String cur = queue.poll();
                List<String> neighbors = getNeighbors(cur, dict);

                for(String neighbor: neighbors) {
                    if(neighbor.equals(endWord)) {
                        return ans+2;
                    }

                    if(!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            ans++;
        }

        return 0;
    }

    private List<String> getNeighbors(String cur, Set<String> dict) {
        List<String> ans = new ArrayList<>();
        char[] charArray = cur.toCharArray();

        for(int i=0; i<charArray.length; i++) {
            for(char c='a'; c<='z'; c++) {
                if(c==charArray[i]) {
                    continue;
                }

                char old = charArray[i];
                charArray[i] = c;

                String tmp = new String(charArray);

                if(dict.contains(tmp)) {
                    ans.add(tmp);
                }

                charArray[i] = old;
            }

        }

        return ans;
    }

}
