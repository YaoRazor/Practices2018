package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    public String decodeString(String s) {
        Deque<String> resstack = new ArrayDeque<>();
        Deque<Integer> countStack = new ArrayDeque<>();
        int n = s.length();
        int i=0;
        String res = "";

        while(i<n) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int cnt = 0;
                while(Character.isDigit(s.charAt(i))) {
                    cnt = cnt*10+s.charAt(i)-'0';
                    i++;
                }

                countStack.push(cnt);
                continue;
            } else if(c=='[') {
                resstack.push(res);
                res = "";

            } else if(c==']') {
                StringBuilder sb = new StringBuilder(resstack.pop());
                int cnt = countStack.pop();
                for(int j=0; j<cnt; j++) {
                    sb.append(res);
                }

                res = sb.toString();

            } else {
                res += s.charAt(i);
            }

            i++;
        }

        return res;
    }
}
