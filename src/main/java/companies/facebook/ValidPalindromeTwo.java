package companies.facebook;


public class ValidPalindromeTwo {

    public boolean validPalindrome(String s) {
        if(s==null || s.length()==0) {
            return false;
        }

        return validPalindrome(s, 0, s.length()-1, false);
    }

    private boolean validPalindrome(String s, int start, int end, boolean isDelete) {
        while(start<end) {
            if(s.charAt(start)!=s.charAt(end)) {
                if(isDelete) {
                    return false;
                } else {
                    return validPalindrome(s, start+1, end, true) || validPalindrome(s, start, end-1, true);
                }

            }
            end--;
            start++;
        }

        return true;
    }
}
