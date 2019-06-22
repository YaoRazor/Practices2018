package miscellaneous;


public class ZigZagConversion {
    public String convert(String s, int numRows) {
        // numRow=1用来防止tmp变成0
        if(s==null || s.length() ==0 || numRows==1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int n = 2*numRows-2;

        for(int i=0; i<numRows; i++) {
            for(int j=i; j<s.length(); j+=n) {
                sb.append(s.charAt(j));
                int tmp = j+n-2*i;

                if(i!=0 && i!=numRows-1 && tmp<s.length()) {
                    sb.append(s.charAt(tmp));
                }
            }
        }

        return sb.toString();
    }
}
