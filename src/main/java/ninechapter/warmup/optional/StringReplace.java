package ninechapter.warmup.optional;

import java.util.HashMap;
import java.util.Map;

// Time complexity is O(a.len*(a.len + s.len))
public class StringReplace {

    public String stringReplace(String[] a, String[] b, String s) {
        // Write your code here
        int MAGIC_NUMBER = 33;
        int MOD = 10000000;

        Map<Integer, Integer> map = new HashMap<>();
        for(int j=0; j<a.length; j++) {

            // The body of this for loop is a variant of strStrTwo
            String target = a[j];
            int n = target.length();

            int power = 1;
            for(int i=0; i<n-1; i++) {
                power*=MAGIC_NUMBER;
                power%=MOD; // mod here in case there is overflow
            }

            int hashcode = 0;
            for(int i=0; i<n; i++) {
                hashcode = (hashcode*(MAGIC_NUMBER%MOD) + target.charAt(i))%MOD;
            }

            int cur = 0;

            for(int i=0; i<s.length(); i++) {
                if(i>=n) {
                    cur -= (s.charAt(i-n))*power;
                    cur%=MOD;
                }

                if(cur<0) {
                    cur+=MOD;
                }

                cur = (cur*MAGIC_NUMBER + s.charAt(i))%MOD;

                if(i>=n-1 && cur==hashcode) {
                    if(s.substring(i-n+1, i+1).equals(target)) {
                        if(!map.containsKey(i-n+1)) {
                            map.put(i-n+1, j);
                        } else {
                            if(b[map.get(i-n+1)].length()<n) {
                                map.put(i-n+1, j);
                            }

                        }

                    }
                }
            }


        }

        StringBuilder sb = new StringBuilder(s);
        int k = 0;
        while(k<s.length()) {
            if(map.containsKey(k)) {
                int length = b[map.get(k)].length();
                sb.replace(k, k+length, b[map.get(k)]);
                k+=length;
            } else {
                k++;
            }

        }

        return sb.toString();
    }
}
