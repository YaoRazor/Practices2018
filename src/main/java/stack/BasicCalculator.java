package stack;

import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        int i = 0;
        int ans = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();

        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }

            if (i == s.length()) {
                break;
            }

            if (Character.isDigit(s.charAt(i))) {
                int cur = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    cur *= 10;
                    cur += s.charAt(i) - '0';
                    i++;
                }
                ans += cur * sign;
                // continue to prevent i++ in the end
                continue;
            } else if (s.charAt(i) == '(') {
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                // need to reset sign as 1 which is a key point
                sign = 1;
            } else if (s.charAt(i) == ')') {
                ans = ans*stack.pop();
                ans = ans+stack.pop();
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else {  // '+' case
                sign = 1;
            }

            i++;
        }

        return ans;
    }
}
