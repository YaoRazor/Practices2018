package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<tokens.length; i++) {

            if(isOperator(tokens[i])) {
                int right = stack.pop();
                int left = stack.pop();
                int result = 0;

                switch(tokens[i]) {
                    case "+":   result = left+right; break;
                    case "-":   result = left-right; break;
                    case "*":   result = left*right; break;
                    case "/":   result = left/right; break;
                }

                stack.push(result);

            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }


        }

        return stack.pop();


    }


    private boolean isOperator(String string) {

        if("*".equals(string) || "+".equals(string) || "-".equals(string) || "/".equals(string)) {
            return true;
        } else {
            return false;
        }

    }
}
