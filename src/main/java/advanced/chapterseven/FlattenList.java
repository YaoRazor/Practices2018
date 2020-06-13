package advanced.chapterseven;

import java.util.ArrayList;
import java.util.List;

interface NestedInteger {
  // @return true if this NestedInteger holds a single integer,
  // rather than a nested list.
  public boolean isInteger();

  // @return the single integer that this NestedInteger holds,
  // if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  public Integer getInteger();

  // @return the nested list that this NestedInteger holds,
  // if it holds a nested list
  // Return null if this NestedInteger holds a single integer
  public List<NestedInteger> getList();
}

public class FlattenList {

    // TC: O(N), there can be stackoverflow is it is nested too deep
    // we can solve this problem in a non-recursive way using stack
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> ans = new ArrayList<>();
        for(NestedInteger tmp: nestedList) {
            if(tmp.isInteger()) {
                ans.add(tmp.getInteger());
            } else {
                List<NestedInteger> subList = tmp.getList();
                ans.addAll(flatten(subList));
            }
        }

        return ans;
    }
}
