package stack;

import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        if(s==null || s.length()==0) {
            return 0;
        }

        // 假设所有的表达式之前都有一个 0+ (current expression)
        int ans = 0;
        int sign = 1; // This sign is used to store the previous operator
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        while(i<s.length()) {
            char c = s.charAt(i);
            if(c==' ') {
                i++;
                continue;
            } else if(Character.isDigit(c)) {
                int tmp = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))) {
                    tmp = tmp*10+ (int)(s.charAt(i)-'0');
                    i++;
                }
                ans += tmp*sign;
                continue;
            } else if(c=='(') { // 每次遇到'('就压栈，栈里存储的是之前的结果以及(之前的符号, 相当于开始evaluate新的子表达式
                stack.push(ans);
                stack.push(sign);
                ans = 0; // ans清零用来存储现有的()括号中的结果
                sign = 1; // sign needs to be reset, this is a key point
            } else if(c==')') {
                ans*=stack.pop();
                ans+=stack.pop();
            } else if(c=='+') {
                sign = 1;
            } else {
                sign = -1;
            }
            i++;
        }

        return ans;
    }
}
