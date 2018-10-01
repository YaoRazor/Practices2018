package miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
    public String toGoatLatin(String S) {

        Set<Character> vowel = new HashSet();
        for (char c: new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'})
            vowel.add(c);

        String[] strs = S.split(" ");

        StringBuilder sb = new StringBuilder();

        int t=1;


        for(String s: strs) {
            Character start = s.charAt(0);

            if(!vowel.contains(start)) {
                s = s.substring(1);
                s = s+start+"ma";
            }

            sb.append(s);

            for(int i=0; i<t; i++) {
                sb.append('a');
            }

            t++;

            sb.append(" ");


        }


        sb.deleteCharAt(sb.length()-1);


        return sb.toString();



    }
}
