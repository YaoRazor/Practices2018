package ninechapter.dfs.optional;

import java.util.ArrayList;

import java.util.*;

public class FindMissingNumberTwo {
    public int findMissing2(int n, String str) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        dfs(ans, set, str, n, 0);
        set.addAll(ans);

        for(int i=1; i<=n; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }

        return 0;
    }


    // There is no sub problem here, because the path of how we get to the point of cur
    // also matters, therefore this problem can only be solved by dfs
    private void dfs(List<Integer> ans, Set<Integer> set, String str, int n, int cur) {
        if(cur==str.length()) {
            if(set.size()==n-1) {
                ans.addAll(set);
            }

            return;
        }

        if(str.charAt(cur)=='0') {
            return;
        }

        for(int i=1; i<=2 && cur+i<=str.length(); i++) {
            int num = Integer.parseInt(str.substring(cur, cur+i));
            if(set.contains(num) || num>n) {
                continue;
            }
            set.add(num);
            dfs(ans, set, str, n, cur+i);
            set.remove(num);
        }

    }

    public static void main(String[] args) {
        FindMissingNumberTwo findMissingNumberTwo = new FindMissingNumberTwo();
        findMissingNumberTwo.findMissing2(20, "19201234567891011121314151618");

    }
}
