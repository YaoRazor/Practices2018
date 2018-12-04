package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    //这道题就是Greedy算法，算出每个字母最后出现的地方，然后那个地方就是baseline,
    //然后看看现有区间有没有超过那个地方的字母，没有的话就partition，有的话就延长现有区间
    //Greedy类型的算法都不是很重要
    public List<Integer> partitionLabels(String S) {

        List<Integer> ans = new ArrayList<>();
        if(S==null || S.length()==0) {
            return ans;
        }

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<S.length(); i++) {
            map.put(S.charAt(i), i);
        }

        int j = 0;
        int anchor = 0;

        for(int i=0; i<S.length(); i++) {

            j = Math.max(j, map.get(S.charAt(i)));

            if(i==j) {
                ans.add(i-anchor+1);
                anchor = i+1;

            }


        }

        return ans;

    }
}
