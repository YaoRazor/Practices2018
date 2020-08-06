package companies.twitter;

import java.util.ArrayList;
import java.util.List;

public class MessageSplit {

    public List<String> splitMessage(String input, int limit) {
        List<String> ans = new ArrayList<>();
        if(input==null || input.length()==0) {
            return ans;
        }

        String[] words = input.split("\\s+");
        int suffixLength = 3;
        int maxLength = limit - suffixLength;

        List<StringBuilder> tmp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int curLength = 0;

        for(String word: words) {
            if(curLength+word.length()+1 < maxLength) {
                sb.append(word);
                sb.append(" ");
            } else {
                tmp.add(sb);
                curLength = 0;
                sb = new StringBuilder();
                sb.append(word);
                sb.append(" ");
            }
            curLength+=(word.length()+1);
        }

        if(curLength>0) {
            tmp.add(sb);
        }

        int size = tmp.size();
        for(int i=0; i<tmp.size(); i++) {
            StringBuilder cur = tmp.get(i);
            cur.append(i+1);
            cur.append("/");
            cur.append(size);
            ans.add(cur.toString());
        }

        return ans;
    }

    public static void main(String[] args) {
        String input = "This is a message. This is a message. This is a message.";
        MessageSplit messageSplit = new MessageSplit();
        List<String> ans = messageSplit.splitMessage(input, 24);
        for(String str: ans) {
            System.out.println(str);
        }
    }
}
