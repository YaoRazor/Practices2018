package companies.facebook;

public class AddBinary {

    public String addBinary(String a, String b) {
        int i = a.length()-1; int j = b.length() -1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        // trick one
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