package stack;

import java.util.List;
import java.util.Stack;

// TC: O(N), SC: O(N)
public class ExclusiveTimeOfFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        if(logs==null) {
            return ans;
        }
        int last = 0;

        for(String log: logs) {
            String[] array = log.split(":");
            int id = Integer.parseInt(array[0]);
            String event = array[1];
            int time = Integer.parseInt(array[2]);

            if("start".equals(event)) {
                if(!stack.isEmpty()) {
                    ans[stack.peek()]+=time-last;
                }
                stack.push(id);
                last = time;
            } else {
                ans[stack.pop()]+=time-last+1;
                last = time+1; // end的时候的时间定义比较奇葩
            }
        }

        return ans;
    }
}
