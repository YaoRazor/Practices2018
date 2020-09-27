package advanced.chapterseven;

import java.util.*;


// 这一题不用stack，直接在队头展开也是可以的，只是用stack展开要
// 方便一些，否则的话需要recursive来展开。有空研究一下时间复杂度
public class FlattenNestedListIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        expand(nestedList);
    }

    private void expand(List<NestedInteger> nestedList) {
        for(int i=nestedList.size()-1; i>=0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty() && !stack.peek().isInteger()) {
            expand(stack.pop().getList());
        }

        return !stack.isEmpty() && stack.peek().isInteger();
    }
}
