package stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if(s==null ) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for(char c: s.toCharArray()) {
            if(c=='(' || c=='[' || c=='{') {
                stack.push(c);
            } else {
                if(stack.isEmpty() || stack.pop()!=map.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
