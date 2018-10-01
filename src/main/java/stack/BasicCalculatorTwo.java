package stack;

import java.util.Stack;

public class BasicCalculatorTwo {
    public int calculate(String s) {

        int ans = 0;

        if(s==null || s.length()==0) {
            return ans;
        }

        Stack<Integer> stack = new Stack<>();
        int num  = 0;
        char sign = '+';

        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);

            if(Character.isDigit(cur)) {
                num = num*10+cur-'0';
            }

            if((!Character.isDigit(cur)) && cur !=' ' || i==s.length()-1) {

                if(sign=='+') {
                    stack.push(num);
                } else if(sign=='-') {
                    stack.push(-num);
                } else if(sign=='*') {
                    stack.push(stack.pop()*num);
                } else if(sign=='/'){
                    stack.push(stack.pop()/num);
                }

                num = 0;
                sign = cur;
                System.out.println(sign+"\n");

            }


        }

        for(Integer i: stack) {
            ans+=i;
        }

        return ans;

    }
}
