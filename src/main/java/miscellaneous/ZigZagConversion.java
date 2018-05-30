package miscellaneous;

/**
 * Created by yawang on 4/29/18.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        // numRow=1用来防止tmp变成0
        if(s==null || s.length() ==0 || numRows==1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int tmp = 2*numRows-2;

        for(int i=0; i<numRows; i++){

            for(int j=i; j<s.length(); j++) {

                if(j%tmp==i || (j+i)%tmp==0) {

                    sb.append(s.charAt(j));
                }


            }

        }

        return sb.toString();

    }
}
