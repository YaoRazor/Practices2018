package array;

public class StringToInteger {
    public int myAtoi(String str) {

        if(str==null) {
            return 0;
        }

        str = str.trim();
        if(str.length()==0) {
            return 0;
        }

        int start = 0;

        boolean isPostive = true;

        if(str.charAt(0)=='+') {
            start = 1;
        } else if(str.charAt(0)=='-'){
            start = 1;
            isPostive = false;
        }


        if(isSpecialCase(str, start)) {
            return 0;
        }

        long ans =0;

        while(start< str.length() && Character.isDigit(str.charAt(start))) {
            ans = ans*10 + (long)(str.charAt(start)-'0');
            start++;
            if(ans>(0l-(long)Integer.MIN_VALUE)) {
                break;
            }
        }

        if(!isPostive) {
            ans = 0-ans;
        }

        if(ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if(ans< Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)ans;
        }

    }


    private boolean isSpecialCase(String str, int start) {

        if(start>=str.length() || !Character.isDigit(str.charAt(start))) {
            return true;
        }
        return false;

    }
}
