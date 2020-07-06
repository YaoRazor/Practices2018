package companies.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumClosest {

    public List<List<Integer>> getMaxPair(List<List<Integer>> list1, List<List<Integer>> list2, int max) {

        List<List<Integer>> ans = new ArrayList<>();

        if(list1==null || list2==null || list1.size()==0 || list2.size()==0) {
            return ans;
        }

        int target = 0;

        for(int i= 0; i<list1.size(); i++) {

            for(int j=0; j<list2.size(); j++) {

                if(list1.get(i).get(1) + list2.get(j).get(1) <=max) {
                    target = Math.max(target, list1.get(i).get(1) + list2.get(j).get(1));
                }


            }


        }

        for(int i= 0; i<list1.size(); i++) {

            for(int j=0; j<list2.size(); j++) {

                if(list1.get(i).get(1) + list2.get(j).get(1) == target) {
                    List<Integer> tmp = Arrays.asList(list1.get(i).get(0), list2.get(j).get(0));
                    ans.add(tmp);
                }


            }

        }

        return ans;

    }
}
