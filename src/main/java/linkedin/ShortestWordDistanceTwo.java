package linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceTwo {

    Map<String, List<Integer>> map = new HashMap<>();

    public ShortestWordDistanceTwo(String[] words) {

        if(words==null || words.length==0) {
            return;
        }

        for(int i=0; i<words.length; i++) {

            if(map.containsKey(words[i])) {
                map.get(words[i]).add(i);

            } else {
                List<Integer> wordIndex = new ArrayList<>();
                wordIndex.add(i);
                map.put(words[i], wordIndex);
            }

        }


    }

    public int shortest(String word1, String word2) {

        List<Integer> index1 = map.get(word1);
        List<Integer> index2 = map.get(word2);

        int i=0;
        int j=0;

        int ans = Math.abs(index1.get(i) - (int)index2.get(j));

        while(i<index1.size() && j<index2.size()) {

            ans = Math.min(ans, Math.abs(index1.get(i) - index2.get(j)));

            if(index1.get(i)<=index2.get(j)) {
                i++;
            } else {
                j++;
            }

        }

        return ans;

    }
}
