package companies.robinhood;

public class SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        if(sentence==null || sentence.length==0) {
            return 0;
        }

        int ans = 0;
        int tmp = cols;

        while(rows>0) {
            int cnt = 0;

            while(cnt<sentence.length) {
                if(tmp>=sentence[cnt].length()) {
                    tmp-=(sentence[cnt].length()+1);
                    cnt++;
                } else {
                    rows--;
                    if(rows==0) {
                        return ans;
                    }
                    tmp = cols;
                }
            }

            if(cnt==sentence.length) {
                ans++;
            }
            cnt = 0;
        }

        return ans;
    }
}
