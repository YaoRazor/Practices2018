package array;

public class ReverseWordsInAStringThree {

    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();

        if(s == null || s.length() == 0) {
            return ans.toString();
        }


        int i = 0;

        while (i<s.length()) {

            while (i<s.length() && s.charAt(i)==' ' ) {
                i++;
            }

            StringBuilder sb = new StringBuilder();

            while (i<s.length() && s.charAt(i)!=' ') {
                sb.insert(0, s.charAt(i));
                i++;
            }

            ans.append(sb.toString()).append(' ');

        }

        if(ans.charAt(ans.length()-1)==' ') {
            ans.deleteCharAt(ans.length()-1);
        }

        return ans.toString();
    }
}
