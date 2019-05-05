package airbnb;

import java.util.HashMap;
import java.util.Map;

public class CollatzConjecture {

    public int findLongestSteps(int num) {

        if(num<1) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 1;

        for(int i=1; i<=num; i++) {

            int step = findSteps(i, map);
            ans = Math.max(ans, step);

        }

        return ans;

    }


    private int findSteps(int num, Map<Integer, Integer> map) {

        if(map.containsKey(num)) {
            return map.get(num);
        }

        if(num==1) {
            return 1;
        }

        int steps = 0;

        if(num%2==0) {
            steps = 1 + findSteps(num/2, map);

        } else {
            steps = 1 + findSteps(3*num+1, map);

        }

        map.put(num, steps);
        return steps;
    }
}
