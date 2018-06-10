package array;


public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();

        if(s == null || s.length() == 0) {
            return ans.toString();
        }


        int i = s.length()-1;

        while (i>=0) {

            while (i>=0 && s.charAt(i)==' ' ) {
                i--;
            }

            StringBuilder sb = new StringBuilder();

            while (i>=0 && s.charAt(i)!=' ') {
                sb.insert(0, s.charAt(i));
                i--;
            }

            if(sb.length()>=1) {
                ans.append(sb.toString()).append(' ');
            }


        }

        if(ans.charAt(ans.length()-1)==' ') {
            ans.deleteCharAt(ans.length()-1);
        }

        return ans.toString();
    }
}
