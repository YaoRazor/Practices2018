package companies.twitter;

import java.util.HashMap;
import java.util.Map;

public class ReplaceAndCapitalize {

    public String convert(String input, Map<String, String> dict) {
       if(input==null || input.length()==0) {
           return "";
       }

       String[] tokens = input.split("\\s+");
       StringBuilder sb = new StringBuilder();

       for(String token: tokens) {
           String tmp = dict.containsKey(token)? dict.get(token): token;
           char[] tmpChars = tmp.toCharArray();
           tmpChars[0] = Character.toUpperCase(tmpChars[0]);
           sb.append(tmpChars);
           sb.append(' ');
       }

       sb.deleteCharAt(sb.length()-1);

       return sb.toString();
    }

    public static void main(String[] args) {
        String input = "I will interview with Twitter tomorrow";
        Map<String, String> dict = new HashMap<>();
        dict.put("tomorrow", "today");
        dict.put("Twitter", "ZooX");
        ReplaceAndCapitalize replaceAndCapitalize = new ReplaceAndCapitalize();

        System.out.println(replaceAndCapitalize.convert(input, dict));
    }

}
