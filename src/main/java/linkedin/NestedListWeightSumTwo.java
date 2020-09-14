package linkedin;

import datastructures.NestedInteger;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSumTwo {


    // 这里本质上是一个BFS的算法，唯一的变化是pre不清零
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int ans = 0;
        int pre = 0;

        List<NestedInteger> currentList = nestedList;

        while(!currentList.isEmpty()) {
            List<NestedInteger> next = new ArrayList<>();

            for(NestedInteger nestedInteger: currentList) {

                if(nestedInteger.isInteger()) {
                    pre+=nestedInteger.getInteger();
                } else {
                    next.addAll(nestedInteger.getList());
                }

            }

            // Pre不清零，所以相当于没进入下面一层，都要把本层再加一遍
            ans+=pre;
            currentList = next;
        }

        return ans;
    }
}
