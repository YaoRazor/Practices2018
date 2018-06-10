package array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        if(numRows==0) {
            return ans;
        }

        List<Integer> init = Arrays.asList(1);
        ans.add(init);

        for(int i=1; i<numRows; i++) {

            List<Integer> cur = new ArrayList<>();
            for(int j=0; j<i+1;j++) {
                if(j==0 || j==i) {
                    cur.add(1);
                } else {
                    cur.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                }

            }

            ans.add(cur);

        }

        return ans;
    }
}
