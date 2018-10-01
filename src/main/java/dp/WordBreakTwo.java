package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakTwo {

    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String>[] dp = new ArrayList[s.length()+1];

        Set<String> set = new HashSet<>(wordDict);

        List<String> intial = new ArrayList<>();

        intial.add("");
        dp[0] = intial;


        for(int i=1; i<=s.length(); i++) {

            List<String> cur = new ArrayList<>();

            for(int j=0; j<i; j++) {

                if(dp[j].size()>0 && set.contains(s.substring(j,i))) {

                    for(String tmp: dp[j]) {
                        cur.add((tmp.equals("")? tmp: tmp+" ")+ s.substring(j, i));
                    }

                }


            }


            dp[i] = cur;

        }

        return dp[s.length()];

    }


}
