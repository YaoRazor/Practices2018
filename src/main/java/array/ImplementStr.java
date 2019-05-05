package array;

// Just O(n^2)，肯定不是KMP就是了
public class ImplementStr {
    public int strStr(String haystack, String needle) {

        if(needle==null || needle.length()==0) {
            return 0;
        }

        if(haystack==null || haystack.length()==0) {
            return -1;
        }

        for(int i=0; i<haystack.length(); i++) {

            if(isMatch(haystack, i, needle)) {
                return i;
            }

        }

        return -1;
    }

    private boolean isMatch(final String haystack, int i, final String needle) {
        int j = 0;

        while(i<haystack.length() && j<needle.length()) {
            if(needle.charAt(j)!=haystack.charAt(i)) {
                return false;
            }

            i++;
            j++;

        }

        if(j==needle.length()) {
            return true;
        } else {
            return false;
        }

    }
}
