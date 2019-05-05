package array;


public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<strs[0].length(); i++) {

            char cur = strs[0].charAt(i);

            for(int j = 1; j<strs.length; j++) {

                // i>=strs[j].length() is the key here, don't forget to add it
                if(i>=strs[j].length() || cur!=strs[j].charAt(i)) {
                    return sb.toString();
                }

            }

            sb.append(cur);
        }

        return sb.toString();
    }
}
