package miscellaneous;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        if(num1==null || num1.length()==0 || num2==null || num2.length()==0) {
            return "";
        }

        int[] result = new int[num1.length()+num2.length()];

        for(int i=num1.length()-1; i>=0; i--) {

            int cur = num1.charAt(i) - '0';

            for(int j=num2.length()-1; j>=0; j--) {

                int tmp = num2.charAt(j) - '0';

                result[i+j+1] += (cur*tmp);

                if(result[i+j+1]>=10) {
                    result[i+j]+=result[i+j+1]/10;
                    result[i+j+1]%=10;

                }
            }

        }

        StringBuilder sb = new StringBuilder();

        int i=0;
        while (result[i]==0 && i<result.length) {
            i++;
        }

        for(;i<result.length; i++) {

            sb.append(result[i]);
        }

        return sb.toString();

    }


}
