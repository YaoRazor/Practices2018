package advanced.chapterseven.optional;

import datastructures.NestedInteger;

import java.util.List;

public class NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList==null || nestedList.size()==0) {
            return 0;
        }

        return depthSum(nestedList, 1);
    }

    private int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for(NestedInteger tmp: nestedList) {
            if(tmp.isInteger()) {
                sum+=depth*tmp.getInteger();
            } else {
                sum+=depthSum(tmp.getList(), depth+1);
            }
        }

        return sum;
    }
}
