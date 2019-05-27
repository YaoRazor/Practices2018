package dp;

public class LongestPalindromicSubstring {

    // Two dimensional DP would be more intuitive, but this method can save some space
    public String longestPalindromeUsingDP(String s) {

        int n = s.length();
        boolean[] dp = new boolean[n];
        String ans = "";

        for (int i = n - 1; i >= 0; i--) {

            for (int j = n - 1; j >= i; j--) {

                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[j - 1])) {

                    dp[j] = true;

                    if (j - i + 1 > ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                } else {
                    dp[j] = false;
                }
            }
        }

        return ans;
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
