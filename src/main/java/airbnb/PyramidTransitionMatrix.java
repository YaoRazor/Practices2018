package airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
这一题其实是两层DFS,
一重DFS是helper function, helper function会recursively调用自己来确定能不能基于当前的bottem生成一个pyramid
第二重DFS是getList这个function递归调用自己来得到对于当前的bottem, 他所有上一层可能的组合
 */
public class PyramidTransitionMatrix {

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        Map<String, List<Character>> map = new HashMap<>();

        for(String s: allowed) {
            String prefix = s.substring(0, 2);
            if(!map.containsKey(prefix)) {
                map.put(prefix, new ArrayList<>());
            }

            map.get(prefix).add(s.charAt(2));
        }

        return helper(bottom, map);

    }


    // helper function用来得到当前的bottem是不是可以生成一个valid的pyramid.
    private boolean helper(final String bottom, final Map<String, List<Character>> map) {
        if(bottom.length()==1) {
            return true;
        }

        for(int i=0; i<bottom.length()-1; i++) {
            if(!map.containsKey(bottom.substring(i, i+2))) {
                return false;
            }
        }

        List<String> candidates = new ArrayList<>();
        getList(bottom, 0, map, new StringBuilder(), candidates);

        for(String s: candidates) {
            if(helper(s, map)) {
                return true;
            }
        }

        return false;
    }


    // getList用来recursively得到对于当前的bottem, 所有可能的上一层的substring
    private void getList(final String bottom, int index, final Map<String, List<Character>> map, StringBuilder sb, List<String> ls) {

        if(index==bottom.length()-1) {
            ls.add(sb.toString());
            return;
        }

        for(Character c: map.get(bottom.substring(index, index+2))) {
            sb.append(c);
            getList(bottom, index+1, map, sb, ls);
            sb.deleteCharAt(sb.length()-1);

        }
    }
}
