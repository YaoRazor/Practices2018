package dfs;

public class CountAndSay {

    public String countAndSay(int n) {
        String ans = "1";

        for(int i=2; i<=n; i++) {
            ans = getString(ans);
        }

        return ans;
    }

    private String getString(String input) {
        int count = 1;
        char cur = input.charAt(0);
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<input.length(); i++) {
            if(cur==input.charAt(i)) {
                count++;
            } else {
                sb.append(count);
                sb.append(cur);
                cur = input.charAt(i);
                count=1;
            }

        }

        sb.append(count);
        sb.append(cur);

        return sb.toString();
    }
}
