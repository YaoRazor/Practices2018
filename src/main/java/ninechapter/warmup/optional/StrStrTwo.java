package ninechapter.warmup.optional;

public class StrStrTwo {

    public int strStr2(String source, String target) {
        if(target == null) {
            return -1;
        }
        int n = target.length();
        if(n == 0 && source != null) {
            return 0;
        }

        if(source == null) {
            return -1;
        }

        int MAGIC_NUMBER = 33;
        int MOD = 10000000;

        int power = 1;
        for(int i=0; i<n-1; i++) {
            power*=MAGIC_NUMBER;
            power%=MOD; // mod here in case there is overflow
        }

        int hashcode = 0;
        for(int i=0; i<target.length(); i++) {

            hashcode = (hashcode*(MAGIC_NUMBER%MOD) + target.charAt(i))%MOD;
        }

        int cur = 0;

        for(int i=0; i<source.length(); i++) {
            if(i>=n) {
                cur -= (source.charAt(i-n))*power;
                cur%=MOD;
            }

            if(cur<0) {
                cur+=MOD;
            }

            cur = (cur*MAGIC_NUMBER + source.charAt(i))%MOD;

            if(i>=n-1 && cur==hashcode) {
                if(source.substring(i-n+1, i+1).equals(target)) {
                    return i-n+1;
                }
            }
        }

        return -1;
    }
}
