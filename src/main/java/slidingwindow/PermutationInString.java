package slidingwindow;

import java.util.HashMap;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int cnt = 0;


        for(int i=0; i<s2.length(); ) {

            char c = s2.charAt(i);

            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);

                if(map.get(c)==0) {
                    cnt++;
                    if(cnt==map.size()) {
                        return true;
                    }
                }
            }

            i++;

            if(i>=s1.length()) {
                c = s2.charAt(i-s1.length());
                if(map.containsKey(c)) {
                    map.put(c, map.get(c)+1);

                    if(map.get(c)==1) {
                        cnt--;
                    }
                }
            }

        }

        return false;
    }
}
