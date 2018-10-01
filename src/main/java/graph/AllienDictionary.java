package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AllienDictionary {

    public String alienOrder(String[] words) {


        HashMap<Character, Integer> inDegree = new HashMap<>();
        HashMap<Character, Set<Character>> map = new HashMap<>();


        if(words==null || words.length==0) {
            return "";
        }

        for(String s: words) {
            for(Character c: s.toCharArray()) {
                if(!inDegree.containsKey(c)) {
                    inDegree.put(c, 0);
                }
            }
        }


        for(int i=0; i<words.length-1; i++) {

            String cur = words[i];
            String next = words[i+1];

            int length = Math.min(cur.length(), next.length());

            for(int j=0; j< length; j++) {

                Character c1 = cur.charAt(j);
                Character c2 = next.charAt(j);

                if(!c1.equals(c2)) {

                    Set<Character> set;

                    if(map.containsKey(c1)) {
                        set = map.get(c1);
                    } else {
                        set = new HashSet<>();
                    }

                    if(!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        inDegree.put(c2, inDegree.get(c2)+1);
                    }

                    break; // This is a very critical break...

                }

            }

        }

        Deque<Character> queue = new ArrayDeque<>();

        for(Character c: inDegree.keySet()) {

            if(inDegree.get(c)==0) {
                queue.addLast(c);
            }

        }

        String result = "";

        while (!queue.isEmpty()) {

            Character cur = queue.pollFirst();
            result+=cur;

            if(map.containsKey(cur)) {

                for(Character c: map.get(cur)) {

                    inDegree.put(c, inDegree.get(c)-1);

                    if(inDegree.get(c)==0) {
                        queue.addLast(c);
                    }

                }

            }
        }


        if(result.length()!=inDegree.size()) {
            return "";
        } else {
            return result;
        }

    }



}
