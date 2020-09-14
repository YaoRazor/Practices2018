package ninechapter.warmup;

public class LongestPalindromicSubstring {


    public String longestPalindromeUsingDP(String s) {
        if(s==null || s.length()==0) {
            return "";
        }

        String ans = s.substring(0, 1);
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0; i<n; i++) {
            dp[i][i] = true;
            if(i+1<n && s.charAt(i)==s.charAt(i+1)) {
                dp[i][i+1] = true;
                ans = s.substring(i, i+2);
            }

        }

        for(int len=3; len<=n; len++) {
            for(int i=0; i+len-1<n; i++) {
                if(s.charAt(i)==s.charAt(i+len-1) && (dp[i+1][i+len-2])) {
                    dp[i][i+len-1] = true;
                    ans = s.substring(i, i+len);
                }
            }
        }

        return ans;
    }

    private int lo, maxLen;

    // Two dimensional DP would be more intuitive, but this method can save some space
    // TC: O(N^2), SC: O(N)
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
