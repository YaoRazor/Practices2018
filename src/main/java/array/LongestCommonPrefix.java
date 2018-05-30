package array;


public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        if(strs==null || strs.length == 0) {
            return sb.toString();
        }

        int length = strs[0].length();
        boolean isCommon = true;

        for(int i=0; i<length; i++) {

            char tmp = strs[0].charAt(i);

            for(int j=1; j<strs.length; j++) {
                if(i>=strs[j].length() || tmp!=strs[j].charAt(i)) {
                    isCommon = false;
                    break;
                }

            }

            if(isCommon) {
                sb.append(tmp);
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
