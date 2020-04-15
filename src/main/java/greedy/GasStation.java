package greedy;

public class GasStation {
    // 这一题就是背答案，无他
    // 1. If car starts at A and can not reach B. Any station between A and B
    // can not reach B.(B is the first station that A can not reach.)
    // 2. If the total number of gas is bigger than the total number of cost. There must be a solution.
    //  (Should I prove them?)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int sum = 0;
        int start = 0;

        for(int i=0; i<gas.length; i++) {
            total += (gas[i]-cost[i]);
            sum += (gas[i]-cost[i]);

            if(sum<0){
                start = i+1;
                sum = 0;
            }
        }

        return total<0? -1: start;
    }
}
