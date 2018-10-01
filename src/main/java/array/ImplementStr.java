package array;

public class ImplementStr {
    public int strStr(String haystack, String needle) {

        if(haystack==null || needle==null) {
            return -1;
        }

        if(haystack.length()==0 && needle.length()==0) {
            return 0;
        }

        for(int i=0; i<haystack.length(); i++) {

            int j= 0;

            while (j<needle.length()) {

                if(i+j>=haystack.length()) {
                    return -1;
                }

                if(haystack.charAt(i+j)!=needle.charAt(j)) {
                    break;
                }

                j++;

                if(j==needle.length()-1) {
                    return i;
                }
            }

        }

        return -1;
    }
}
