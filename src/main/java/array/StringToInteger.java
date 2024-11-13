package array;

class Solution {
    public int myAtoi(String s) {
        long ans = 0;
        int i = 0;

        while(i<s.length() && s.charAt(i)==' ') {
            i++;
        }

        int sign = 1;

        if(i<s.length() && (s.charAt(i)=='-' || s.charAt(i)=='+')) {
            if(s.charAt(i)=='-') {
                sign = -1;
            }
            i++;
        }

        while(i<s.length() && Character.isDigit(s.charAt(i))) {
            ans*=10l;
            ans+=(long)(s.charAt(i)-'0');
            if(ans>Integer.MAX_VALUE) {
                break;
            }
            i++;
        }

        ans = ans*sign;

        if(ans<Integer.MIN_VALUE) {
            ans = Integer.MIN_VALUE;
        } else if(ans>Integer.MAX_VALUE) {
            ans = Integer.MAX_VALUE;
        }

        return (int) ans;
    }
}
