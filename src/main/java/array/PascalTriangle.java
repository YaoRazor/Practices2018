package array;


import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<numRows; i++) {

            List<Integer> tmp = new ArrayList<>();

            for(int j=0; j<=i; j++) {
                if(j==0 || j==i) {
                    tmp.add(1);
                } else {
                    tmp.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
                }
            }

            ans.add(tmp);

        }

        return ans;
    }
}
