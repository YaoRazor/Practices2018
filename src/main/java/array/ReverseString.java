package array;


public class ReverseString {
    public String reverseString(String s) {

        StringBuilder sb = new StringBuilder();

        if(s==null || s.length()==0) {
            return sb.toString();
        }

        for(int i=s.length()-1; i>=0; i--) {

            sb.append(s.charAt(i));

        }

        return sb.toString();
    }
}
