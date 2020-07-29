package ninechapter.dp_topdown.related;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {

    public boolean Permutation(String A, String B) {
        if (A == null && B == null || A.length() == 0 && B.length() == 0) return true;
        if (A ==null || B == null || A.length() != B.length()) return false;
        Map<Character, Integer> diff = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i), b = B.charAt(i);
            diff.put(a, diff.getOrDefault(a, 0) + 1);
            diff.put(b, diff.getOrDefault(b, 0) - 1);
        }

        for (int v : diff.values()) {
            if (v != 0) return false;
        }
        return true;
    }
}
