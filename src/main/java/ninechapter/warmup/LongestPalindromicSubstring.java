package ninechapter.warmup;

public class LongestPalindromicSubstring {

    // Two dimensional DP would be more intuitive, but this method can save some space
    public String longestPalindromeUsingDP(String s) {

        if(s==null || s.length()==0) {
            return "";
        }

        int n = s.length();

        boolean[][] dp= new boolean[n][n];

        String result = s.substring(0, 1);

        for(int i=0; i<n; i++) {
            dp[i][i] = true;
        }

        for(int i=2; i<=n; i++) {
            for(int j=0; j+i<=n; j++) {

                if(s.charAt(j)==s.charAt(j+i-1)) {

                    if(i==2) {
                        dp[j][j+i-1] = true;
                    } else if(dp[j+1][j+i-2]) {
                        dp[j][j+i-1] = true;
                    }

                    if(dp[j][j+i-1] && i>result.length()) {
                        result = s.substring(j, j+i);
                    }

                }

            }

        }

        return result;
    }

    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
