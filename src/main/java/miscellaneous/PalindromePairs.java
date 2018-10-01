package miscellaneous;

import java.util.*;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> ans = new ArrayList<>();

        if(words==null || words.length==0) {
            return ans;
        }

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<words.length; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }


        for(int i=0; i< words.length; i++) {

            String cur = words[i];

            for(int j=0; j<=cur.length(); j++) {

                String left = cur.substring(0, j);
                String right = cur.substring(j);


                if(isPalindrome(left) && map.containsKey(right) && map.get(right)!=i) {

                    ans.add(Arrays.asList(map.get(right), i));

                }


                if(isPalindrome(right) && map.containsKey(left) &&map.get(left)!=i && right.length()!=0) {
                    ans.add(Arrays.asList(i, map.get(left)));
                }


            }



        }

        return ans;
    }



    private boolean isPalindrome(final String s) {

        int i=0;
        int j= s.length()-1;
        while (i<j){

            if(s.charAt(i++)!=s.charAt(j--)) {
                return false;
            }

        }

        return true;
    }

}
