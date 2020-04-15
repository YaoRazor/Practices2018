package ninechapter.section_one;

// Just O(n^2)，肯定不是KMP就是了
public class ImplementStr {
    public int strStr(String source, String target) {
        if( target.length()>source.length()){
            return -1;
        }

        // Handle edge case, this is actually a communication problem
        if(target.length()==0) {
            return 0;
        }

        for(int i=0; i+target.length()<=source.length(); i++) {

            for(int j=0; j<target.length(); j++) {

                if(target.charAt(j)!=source.charAt(i+j)) {
                    break;
                }

                if(j==target.length()-1) {
                    return i;
                }

            }

        }

        return -1;
    }
}
