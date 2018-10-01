package design;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {

    ArrayDeque<Integer> integerList = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {

        flatternList(nestedList);

    }


    private void flatternList(List<NestedInteger> nestedList) {

        for (NestedInteger nestedInteger : nestedList) {

            if (nestedInteger.isInteger()) {
                integerList.add(nestedInteger.getInteger());
            } else {
                flatternList(nestedInteger.getList());

            }
        }
    }

    @Override
    public Integer next() {
        return integerList.removeFirst();
    }

    @Override
    public boolean hasNext() {

        return integerList.isEmpty();
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}
