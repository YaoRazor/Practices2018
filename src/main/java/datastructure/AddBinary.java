package datastructure;

public class AddBinary {

    public String addBinary(String a, String b) {

        // Trick one
        if(a==null || a.length() == 0) {
            return b;
        }

        if(b==null || b.length() == 0) {
            return a;
        }

        int i = a.length()-1; int j = b.length() -1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();


        while(i>=0 || j>=0) {

            int sum = carry;
            if(i>=0) {
                sum+=a.charAt(i--)-'0';

            }

            if(j>=0) {
                sum+=b.charAt(j--)-'0';
            }

            sb.append(sum%2);
            carry = sum/2;
        }

        // trick two
        if(carry>0) {
            sb.append(carry);
        }

        // trick three
        return sb.reverse().toString();

    }

}