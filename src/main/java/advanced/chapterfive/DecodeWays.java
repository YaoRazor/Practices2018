package advanced.chapterfive;


public class DecodeWays {

    // TC: O(N), SC:O(N)
    public int numDecodings(String s) {
        if(s==null || s.length()==0) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = countNminusOne(dp, 1, s);

        for(int i=2; i<=n; i++) {
            dp[i] = countNminusOne(dp, i, s) + countNminusTwo(dp, i, s);
        }

        return dp[n];
    }

    private int countNminusOne(int[] dp, int i, String s) {
        return s.charAt(i-1)=='0'?0:dp[i-1];
    }

    private int countNminusTwo(int[] dp, int i, String s) {
        if(s.charAt(i-2)=='0') {
            return 0;
        } else {
            int cur = Integer.parseInt(s.substring(i-2, i));
            if(cur>=10 && cur<=26) {
                return dp[i-2];
            } else {
                return 0;
            }
        }
    }
}
