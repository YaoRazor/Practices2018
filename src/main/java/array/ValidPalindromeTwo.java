package array;


public class ValidPalindromeTwo {
    public boolean validPalindrome(String s) {
        if(s==null || s.length()==0) {
            return false;
        }

        int start = 0;
        int end = s.length()-1;
        return validPalindrome(s, start, end, false);
    }

    private boolean validPalindrome(String s, int start, int end, boolean isDelete) {
        while(start<end) {
            if(s.charAt(start)!=s.charAt(end)) {

                if(isDelete) {
                    return false;
                } else {
                    return validPalindrome(s, start+1, end, true) || validPalindrome(s, start, end-1, true);
                }

            } else {
                end--;
                start++;
            }
        }

        return true;
    }
}
