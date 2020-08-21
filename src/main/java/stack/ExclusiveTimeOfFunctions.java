package stack;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];

        if(logs==null || logs.size()==0) {
            return ans;
        }

        Stack<Integer> stack = new Stack<>();
        int pre = 0;

        for(int i=0; i<logs.size(); i++) {
            String[] array = logs.get(i).split(":");
            String action = array[1];
            int id = Integer.parseInt(array[0]);
            int cur = Integer.parseInt(array[2]);

            // 每次都结算当前时间与当上一次action的时间的差
            if("start".equals(action)) {
                if(!stack.isEmpty()) {
                    ans[stack.peek()] +=cur-pre;
                }

                stack.push(id);
            } else {
                cur+=1;  //当action是end的时候，timestamp的定义比较奇葩
                ans[id]+=cur-pre;
                stack.pop(); //这里的id和stack.pop()出来的值是一样的
            }

            pre = cur;
        }

        return ans;
    }
}
