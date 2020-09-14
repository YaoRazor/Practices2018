package companies.facebook;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    // TC: O(N^2), SC:O(1)
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
                    // 这里push的是sb.length()-1，不是i
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
            //这个操作算法复杂度是O(n)
            sb.deleteCharAt(stack.pop());
        }

        return sb.toString();
    }

    // TC: O(N), SC: O(N)
    public String minRemoveToMakeValidUsingExtraArray(String s) {
        boolean[] isValid = new boolean[s.length()];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c!='(' && c!=')') {
                isValid[i]= true;
            } else if(c=='(') {
                stack.push(i);
            } else {
                if(!stack.isEmpty()) {
                    isValid[stack.pop()] = true;
                    isValid[i] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<isValid.length; i++) {
            if(isValid[i]) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
