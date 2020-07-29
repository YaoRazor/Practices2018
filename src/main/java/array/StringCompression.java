package array;

public class StringCompression {
    public int compress(char[] chars) {
        int index = -1;
        char cur = chars[0];
        int cnt = 1;

        for(int i=1; i<=chars.length; i++) {
            if(i!=chars.length && chars[i]==cur) {
                cnt++;
            } else {
                chars[++index] = cur;
                if(cnt!=1) {
                    String str = String.valueOf(cnt);
                    char[] tmp = str.toCharArray();
                    for(int j=0; j<tmp.length; j++) {
                        chars[++index] = tmp[j];
                    }
                }
                if(i!=chars.length) {
                    cur = chars[i];
                    cnt = 1;
                }
            }
        }

        return index+1;
    }
}
