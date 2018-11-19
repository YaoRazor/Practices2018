package airbnb;

import java.util.ArrayList;
import java.util.List;

public class CSVParser {


    public String parseString(final String str) {

        if(str==null || str.length()==0) {
            return "";
        }

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuote = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (inQuote) {
                if (c == '"') {
                    if (i + 1 < str.length() && str.charAt(i + 1) == '"') {
                        sb.append('"');
                        i++;
                    } else {
                        inQuote = false;
                        //这里其实还是比较有意思，为什么这里不放进list里
                    }
                } else {
                    sb.append(c);
                }
            } else {
                if (c == '"') {
                    inQuote = true;
                } else if (c == ',') {
                    list.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(c);
                }
            }
        }
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        return String.join("|", list);

    }
}
