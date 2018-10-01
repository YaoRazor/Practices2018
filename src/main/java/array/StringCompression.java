package array;

public class StringCompression {
    public int compress(char[] chars) {
        int cnt = 0;
        int cur = 1;

        for(int i=1; i<=chars.length; i++) {

            if(i==chars.length || chars[i]!=chars[i-1]) {
                chars[cnt++]  = chars[i-1];

                if(cur>1) {
                    String tmp = String.valueOf(cur);
                    for(int j=0; j<tmp.length();j++) {
                        chars[cnt++] = tmp.charAt(j);
                    }
                }

                cur = 1;

            } else {
                cur++;
            }

        }

        return cnt;
    }
}
