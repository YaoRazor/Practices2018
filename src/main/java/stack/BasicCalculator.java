package stack;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        // 假设所有的表达式之前都有一个 0+ (current expression)
        int ans = 0;
        int sign = 1; // This sign is used to store the previous operator
        int i =0;

        while(i<s.length()) {

            if(s.charAt(i)==' ') {
                i++;
                continue;
            }

            int number = 0;
            while(i<s.length() && Character.isDigit(s.charAt(i))) {
                number = number*10+ (s.charAt(i)-'0');
                i++;
            }

            ans = ans + number * sign;

            if(i==s.length()) {
                break;
            }

            // 每次遇到'('就压栈，栈里存储的是之前的结果以及(之前的符号, 相当于开始evaluate新的子表达式
            if(s.charAt(i)=='(') {
                stack.push(ans);
                stack.push(sign);
                ans = 0; // ans清零用来存储现有的()括号中的结果
                sign = 1;

            } else if(s.charAt(i)==')') {
                ans = ans * stack.pop() + stack.pop(); // 把当前的()中的结果和之前的结果进行整合
                sign = 1;

            } else if(s.charAt(i)=='+') {
                sign = 1;
            } else {
                sign = -1;
            }

            i++;

        }

        return ans;

    }
}
