package companies.facebook;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        Set<String> skip = new HashSet<>();
        skip.add("");
        skip.add(".");
        skip.add("..");

        String[] array = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String str: array) {
            if(str.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }

            } else if(!skip.contains(str)) {
                stack.push(str);
            }
        }

        String res = "";

        while(!stack.isEmpty()) {
            String str = stack.pop();
            res = "/"+str+res;
        }

        return res.isEmpty() ? "/" : res;
    }
}
