package array;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    // TC: O(n), SC: O(n)
    public boolean canConstruct(String ransomNote, String magazine) {
        // Can check with interviewer on edge cases, for example
        // what if ransomNote or magazine is null string
        if(ransomNote==null || magazine==null || ransomNote.length()>magazine.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(char c: magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c: ransomNote.toCharArray()) {
            if(!map.containsKey(c) || map.get(c)==0) {
                return false;
            }

            map.put(c, map.get(c)-1);
        }

        return true;
    }

    // This is a more hacky solution but faster, it is basically
    // using a simplified version of hashmap
    public boolean canConstructTwo(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] alphabets_counter = new int[26];

        for (char c : magazine.toCharArray())
            alphabets_counter[c-'a']++;

        for (char c : ransomNote.toCharArray()){
            if (alphabets_counter[c-'a'] == 0) return false;
            alphabets_counter[c-'a']--;
        }
        return true;
    }
}
