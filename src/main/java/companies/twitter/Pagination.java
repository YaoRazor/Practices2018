package companies.twitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pagination {

    public List<StringBuilder> pagination(String input, int limit) {
        List<StringBuilder> ans = new ArrayList<>();
        if(input==null || input.length()==0) {
            return ans;
        }

        // track the last index number
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int curLine = 0;
        int cnt = 0;
        ans.add(new StringBuilder());

        while(i<input.length()) {
            char c = input.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, curLine);
                ans.get(curLine).append(c);
                cnt++;
            } else {
                int lastIndex = map.get(c);
                if(lastIndex<curLine) {
                    map.put(c, curLine);
                    ans.get(curLine).append(c);
                    cnt++;
                } else {
                    lastIndex++;
                    map.put(c, lastIndex);
                    if(ans.size()<lastIndex+1) {
                        ans.add(new StringBuilder());
                    }
                    ans.get(lastIndex).append(c);
                }
            }

            if(cnt==limit) {
                curLine++;
                if(ans.size()<curLine+1) {
                    ans.add(new StringBuilder());
                }
                cnt=ans.get(curLine).length();
            }
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Pagination pagination = new Pagination();
        String input ="fheauiereiaubfcajeuhuevdaheuhr";
//        String input ="aaaaabbbbckdjfeir";
        List<StringBuilder> ans = pagination.pagination(input, 3);
        for(StringBuilder sb: ans) {
            System.out.println(sb.toString());
        }
    }

}
