package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

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
        return ("*".equals(string) || "+".equals(string) || "-".equals(string) || "/".equals(string));
    }
}
