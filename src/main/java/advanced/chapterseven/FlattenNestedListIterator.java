package advanced.chapterseven;

import java.util.*;


// 这一题不用stack，直接在队头展开也是可以的，只是用stack展开要
// 方便一些，否则的话需要recursive来展开。有空研究一下时间复杂度
public class FlattenNestedListIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        if(nestedList==null || nestedList.size()==0) {
            return;
        }

        int n = nestedList.size();
        for(int i=n-1; i>=0; i--) {
            stack.push(nestedList.get(i));
        }

        getNextElement();
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    private void getNextElement() {
        while(!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger cur = stack.pop();
            List<NestedInteger> newList = cur.getList();
            int n = newList.size();
            for(int i=n-1; i>=0; i--) {
                stack.push(newList.get(i));
            }
        }

    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        getNextElement();
        return !stack.isEmpty();
    }

    @Override
    public void remove() {}
}
