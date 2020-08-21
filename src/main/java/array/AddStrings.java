package array;


public class AddStrings {

    public String addStrings(String num1, String num2) {
        if(num1 == null || num2 == null) {
            return num1==null? num2: num1;
        }

        StringBuilder sb = new StringBuilder();

        int m = num1.length()-1;
        int n = num2.length()-1;

        int carryOn = 0;

        while (m>=0 || n>=0) {
            int numberOfnum1 = m>=0? num1.charAt(m)-'0':0;
            int numberOfnum2 = n>=0?num2.charAt(n)-'0':0;
            int cur = numberOfnum1+numberOfnum2+carryOn;
            sb.append(cur%10);

            carryOn = cur/10;

            m--;
            n--;
        }

        if(carryOn>0) {
            sb.append(carryOn);
        }

        return sb.reverse().toString();
    }


}
