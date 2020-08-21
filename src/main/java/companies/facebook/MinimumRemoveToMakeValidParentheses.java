package companies.facebook;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c!='(' && c!=')') {
                sb.append(c);
            } else {
                if(c=='(') {
                    sb.append('(');
                    stack.push(sb.length()-1);
                } else {
                    if(!stack.isEmpty()) {
                        stack.pop();
                        sb.append(')');
                    }
                }
            }
        }

        while(!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }

        return sb.toString();
    }
}
