package array;


public class LenghtOfLastWord {

    public int lengthOfLastWord(String s) {
        int length = 0;

        if(s==null || s.length()==0) {
            return 0;
        }

        int i = s.length()-1;

        while (s.charAt(i)==' ') {
            i--;
        }

        while (s.charAt(i)!=' ') {
            length++;
            i--;
        }

        return length;
    }
}
