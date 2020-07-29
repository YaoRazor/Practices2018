package stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if(s==null || s.length()==0) {
            return true;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c=='(' || c=='{' || c=='[') {
                stack.push(c);
                continue;
            }

            if(stack.isEmpty() || stack.pop()!=map.get(c)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
