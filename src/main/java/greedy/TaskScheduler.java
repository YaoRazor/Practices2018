package greedy;


public class TaskScheduler {

    // I don't like greed algorithms
    public int leastIntervalTwo(char[] tasks, int n) {
        int[] cnt = new int[26];
        int max = 0;
        for(char c: tasks) {
            cnt[c-'A']++;
            max = Math.max(max, cnt[c-'A']);
        }

        // Use max frequency characters to estimate the number of slots
        // and multiply that with slot size
        int ans = (max-1)*(n+1);

        for(int i: cnt) {
            // For every max frequency element, we need to place to extra slot
            if(i==max) {
                ans++;
            }
        }

        // tasks.length is to cover the case that there are no idle tasks
        // in the sequences while ans is the cover the cases that there are idle
        // tasks in the sequences
        return Math.max(ans, tasks.length);
    }
}
