package airbnb;

import java.util.*;

public class AllienDictionary {

    //本题就是一道典型的拓扑排序
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        if(words==null || words.length==0) {
            return "";
        }

        for(String word: words) {
            for(char c: word.toCharArray()) {
                indegree.put(c, 0);
                map.put(c, new HashSet<>());
            }
        }

        for(int i=1; i<words.length; i++) {
            String pre = words[i-1];
            String cur = words[i];

            // 找到两个string里比较短的那个
            int length = Math.min(pre.length(), cur.length());

            for(int j= 0; j<length; j++) {
                char p = pre.charAt(j);
                char c = cur.charAt(j);

                //只有p!=c这里才有关于order的信息，然后马上就要break, 因为后面已经没有信息了
                if(p!=c) {
                    Set<Character> set = map.get(p);
                    if(!set.contains(c)) {
                        set.add(c);
                        indegree.put(c, indegree.get(c)+1);
                    }
                    break;
                }

            }
        }

        Deque<Character> deque = new ArrayDeque<>();
        List<Character> list = new ArrayList<>();

        for(char c: indegree.keySet()) {
            if(indegree.get(c)==0) {
                deque.addLast(c);
            }
        }

        while(!deque.isEmpty()) {
            char cur = deque.pollFirst();
            list.add(cur);
            for(char to: map.get(cur)) {
                indegree.put(to, indegree.get(to)-1);
                if(indegree.get(to)==0) {
                    deque.addLast(to);
                }
            }
        }

        if(list.size()!=indegree.size()) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();

            for(char c: list) {
                sb.append(c);
            }

            return sb.toString();
        }

    }

}
