package stack;

import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        if(s==null || s.length()==0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int sign = 1;

        int num = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c==' ') {
                continue;
            }

            if(Character.isDigit(c)) {
                num = num*10+c-'0';
            } else if(c=='+') {
                // 这里的sign是前一个sign
                result += num*sign;
                sign = 1;
                num = 0;
            } else if(c=='-') {
                result += num*sign;
                sign = -1;
                num = 0;
            } else if(c=='(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0; // 这里需要reset result = 0, 因为要evaluate新的表达式了，这是一个key point
                num = 0;
            } else {
                result+= num*sign;
                result*=stack.pop();
                result+=stack.pop();
                sign = 1; //每个表达式前面default有一个'+'
                num = 0;
            }
        }

        // 这里需要收尾，这也是一个key point
        if(num>0) {
            result += sign*num;
        }

        return result;
    }
}
