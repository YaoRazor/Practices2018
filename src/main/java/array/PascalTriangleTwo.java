package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PascalTriangleTwo {
    public List<Integer> generate(int numRows) {

        List<Integer> ans = new ArrayList<>();

        if(numRows==0) {
            return ans;
        }

        ans.add(1);

        for(int i=1; i<numRows; i++) {

            ans.add(1);
            int pre = 1;
            for(int j=1; j<i;j++) {
                int tmp = ans.get(j);
                ans.set(j, pre + ans.get(j));
                pre = tmp;

            }
        }

        return ans;
    }
}
