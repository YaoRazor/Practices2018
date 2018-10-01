package dfs;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        List<Integer> notUsedYet = new ArrayList<>();

        int weight = 1;

        for(int i=1; i<=n; i++) {
            notUsedYet.add(i);
            if(i!=n) {
                weight*=i;
            }
        }

        String ans = "";
        k = k-1;

        // while true is very important, for the last few elements, k will always be 0
        while(true) {
            int index = k/weight;
            ans+=notUsedYet.remove(index);

            if(notUsedYet.isEmpty()) {
                break;
            }

            k=k%weight;
            weight=weight/notUsedYet.size();
        }

        return ans;

    }

}
