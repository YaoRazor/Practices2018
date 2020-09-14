package advanced.chapterthree;

import java.util.*;

public class DecodeString {

    // There are two key points of this problem, first we need two stacks
    // second, the thing we store in the strStack is the previous string
    // O(N)
    public String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<String> pre = new Stack<>();
        int cnt = 0;
        String cur = "";

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                cnt = cnt*10+c-'0';
            } else if(Character.isLetter(c)) {
                cur+=c;
            } else if(c=='[') {
                pre.push(cur);
                cur = "";
                stack.push(cnt);
                cnt = 0;
            } else {
                StringBuilder sb = new StringBuilder(pre.pop());
                cnt = stack.pop();
                for(int j=0; j<cnt; j++) {
                    sb.append(cur);
                }
                cnt = 0;
                cur = sb.toString();
            }
        }

        return cur;
    }
}
