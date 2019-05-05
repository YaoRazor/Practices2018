package airbnb;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int index = 0;

        while(index<words.length) {
            int count = words[index].length();
            int last = index+1;

            while(last<words.length) {
                if(count+words[last].length()+1>maxWidth) {
                    break;
                }
                count +=(words[last].length()+1);
                last++;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);
            int diff = last-index-1;

            // last line or only one word in this line
            if(last==words.length || diff==0) {
                for(int i=index+1; i<last; i++) {
                    sb.append(' ');
                    sb.append(words[i]);
                }

                for(int i=sb.length(); i<maxWidth; i++) {
                    sb.append(' ');
                }
            } else {
                int spaces = (maxWidth-count)/diff;
                int remaining = (maxWidth-count)%diff;

                for(int i=index+1; i<last; i++) {

                    for(int j=0; j<spaces; j++) {
                        sb.append(' ');
                    }

                    if(remaining>0) {
                        sb.append(' ');
                        remaining--;
                    }

                    sb.append(' ');
                    sb.append(words[i]);
                }

            }

            ans.add(sb.toString());
            index = last;
        }

        return ans;
    }
}
