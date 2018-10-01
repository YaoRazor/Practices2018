package dp;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        int n = s.length();

        boolean[] dp = new boolean[n];

        String ans = "";


        for(int i=n-1; i>=0; i--) {

            for(int j= n-1; j>=i; j--) {

                if(s.charAt(i)==s.charAt(j) && (j-i<3 || dp[j-1])) {

                    dp[j] = true;

                    if(j-i+1> ans.length()) {
                        ans = s.substring(i, j+1);
                    }

                }


            }

        }


        return ans;


    }
}
