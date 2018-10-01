package dp;

public class PalindromePartitioningTwo {

    public int minCut(String s) {

        if(s==null || s.length()==0) {
            return 0;
        }

        int n = s.length();

        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            dp[i] = i;
        }

        boolean[][] isPalindrome = new boolean[n][n];


        for(int i=1; i<n; i++) {

            for(int j=0; j<=i; j++) {

                if((s.charAt(j)==s.charAt(i) && (i-j<2 || isPalindrome[j+1][i-1]))) {

                    isPalindrome[j][i] = true;

                    if(j==0) {
                        dp[i] = 0;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j-1]+1);
                    }

                }

            }

        }

        return dp[n-1];

    }
}
