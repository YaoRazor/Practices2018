package companies.robinhood;

import java.util.Stack;

public class XiaoxiaoLe {

    class Node {
        char c;
        int count;
        Node(char c, int count) {
            this.c = c;
            this.count = count;
        }

    }

    public String xiaoxiaoLe(final String input) {
        if(input==null || input.length()==0) {
            return "";
        }

        Stack<Node> stack = new Stack<>();

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if(!stack.isEmpty() && stack.peek().c==c) {
                stack.peek().count++;
            } else {
                if(!stack.isEmpty() && stack.peek().count>=3) {
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek().c==c) {
                    stack.peek().count++;
                } else {
                    stack.push((new Node(c, 1)));
                }
            }
        }
        if (!stack.isEmpty() && stack.peek().count>=3) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            for(int i=0; i<cur.count; i++) {
                sb.insert(0, cur.c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        XiaoxiaoLe xiaoxiaoLe = new XiaoxiaoLe();
        System.out.println("input is aabbbbaccddddc output is "+ xiaoxiaoLe.xiaoxiaoLe("aabbbbaccddddc"));

        System.out.println("input is aaaaa output is "+ xiaoxiaoLe.xiaoxiaoLe("aaaaa"));

        System.out.println("input is aabba output is "+ xiaoxiaoLe.xiaoxiaoLe("aabba"));
    }

}
