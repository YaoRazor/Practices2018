package ninechapter.warmup;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s==null || s.length()==0) {
            return true;
        }

        int start = 0;
        int end = s.length()-1;


        while(start<end) {

            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            } else if(!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {

                if(Character.toUpperCase(s.charAt(start))!=Character.toUpperCase(s.charAt(end))) {
                    return false;
                } else {
                    start++;
                    end--;
                }

            }

        }

        return true;
    }
}
