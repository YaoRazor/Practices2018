package stack;

import java.util.Stack;

// 和BasicCalcuator I不同的地方是这里的stack
// 里存的是两个operator之间的值，如果operator是*或者/，那么会将
// 多个operand合成一个
public class BasicCalculatorTwo {
    public int calculate(String s) {
        if(s==null || s.length()==0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)==' ') {
                // key point here, this is used to handle last number
                if(i!=s.length()-1) {
                    continue;
                }
            }

            if(Character.isDigit(s.charAt(i))) {
                num = num*10+(s.charAt(i)-'0');
                if(i!=s.length()-1) {
                    continue;
                }
            }

            // when reaching here, two possibilities
            // i=s.length()-1 or s.charAt(i) is one of four operators
            if(sign=='+') {
                stack.push(num);
            } else if(sign=='-') {
                stack.push(-num);
            } else if(sign=='*') {
                stack.push(stack.pop()*num);
            } else {
                stack.push(stack.pop()/num);
            }

            num = 0;

            if(i!=s.length()-1) {
                sign = s.charAt(i);
            }
        }

        int ans = 0;
        for(int tmp: stack) {
            ans+=tmp;
        }

        return ans;
    }
}
