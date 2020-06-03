package ninechapter.warmup.optional;

public class RotateStringTwo {
    public String RotateString2(String str, int left, int right) {
        if(str==null || str.length()==0) {
            return str;
        }

        int n = str.length();

        int offset = left-right;
        int abs_Offset = Math.abs(offset) % n;

        if(offset==0) {
            return str;
        }

        if(offset>0) {
            return str.substring(abs_Offset) + str.substring(0, abs_Offset);
        } else {
            return str.substring(str.length()-abs_Offset) + str.substring(0, str.length()-abs_Offset);
        }
    }
}
