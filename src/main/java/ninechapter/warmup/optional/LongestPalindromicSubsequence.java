package ninechapter.warmup.optional;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if(s==null || s.length()==0) {
            return 0;
        }

        int n = s.length();

        int[][] dp = new int[n][n];

        for(int length=1; length<=n;length++) {
            for(int i=0; i+length-1<n; i++) {
                if(length==1) {
                    dp[i][i] = 1;
                } else if(length==2) {
                    if(s.charAt(i)==s.charAt(i+length-1)) {
                        dp[i][i+length-1] = 2;
                    } else {
                        dp[i][i+length-1] = 1;
                    }
                } else {
                    if(s.charAt(i)==s.charAt(i+length-1)) {
                        dp[i][i+length-1] = dp[i+1][i+length-2] + 2;
                    } else {
                        dp[i][i+length-1] = Math.max(dp[i+1][i+length-1], dp[i][i+length-2]);
                    }
                }
            }
        }

        return dp[0][n-1];
    }
}
