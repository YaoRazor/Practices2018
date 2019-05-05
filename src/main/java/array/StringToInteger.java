package array;



class Solution {
    public int myAtoi(String str) {
        if(str==null || str.length()==0) {
            return 0;
        }

        int i=0;

        // Remove leading zeroes
        while(i<str.length()) {
            if(str.charAt(i)==' ') {
                i++;
            } else {
                break;
            }
        }

        // Check whether it has reached the end
        if(i>=str.length()) {
            return 0;
        }

        return parseInt(str, i);
    }

    private int parseInt(String s, int i) {
        boolean isNegative = false;
        long ans = 0;

        // Check sign
        if(s.charAt(i)=='-' || s.charAt(i)=='+') {
            isNegative = s.charAt(i)=='-'? true: false;
            i++;
        }

        // Check number
        for(; i<s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                ans = ans*10 + (s.charAt(i)-'0');
                // Handle overflow
                if(ans> (long)Integer.MAX_VALUE) {
                    break;
                }
            } else {
                break;
            }

        }

        ans = isNegative? -ans: ans;

        if(ans<Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if(ans>Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int)ans;
        }
    }
}
