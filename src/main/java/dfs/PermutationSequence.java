package dfs;


public class PermutationSequence {

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int step = 1;

        for(int i=1; i<=n; i++) {
            step = step*i;
        }
        boolean[] isUsed = new boolean[n];
        dfs(n, n, step, k, sb, isUsed);
        return sb.toString();
    }

    private void dfs(int level, int n, int step, int k, StringBuilder sb, boolean[] isUsed) {
        if(level==0) {
            return;
        }

        step = step/level;
        int cnt = 0;

        for(int i=0; i<n; i++) {

            if(isUsed[i]) {
                continue;
            }

            if(cnt+step>=k) {
                level--;
                isUsed[i] = true;
                sb.append(i+1);
                dfs(level, n, step, k-cnt, sb, isUsed);
                break;
            }

            cnt+=step;
        }

    }

}
