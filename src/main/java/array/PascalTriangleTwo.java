package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PascalTriangleTwo {
    public List<Integer> generate(int rowIndex) {
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<=rowIndex; i++) {
            List<Integer> tmp = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i) {
                    tmp.add(1);
                } else {
                    int cur = ans.get(j)+ans.get(j-1);
                    tmp.add(cur);
                }
            }
            ans = tmp;
        }

        return ans;
    }
}
