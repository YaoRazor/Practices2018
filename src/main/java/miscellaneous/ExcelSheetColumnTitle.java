package miscellaneous;


public class ExcelSheetColumnTitle {
    public String convertToTitleOptimal(int n) {
        StringBuilder sb = new StringBuilder();

        while(n>0) {
            n--; //Minus one every time, this is the key to this problem
            char cur = (char) (n%26+'A');
            sb.append(cur);
            n = n/26;
        }

        // Attention! There is a reverse here
        return sb.reverse().toString();
    }

    public String convertToTitleOriginal(int n) {
        StringBuilder sb = new StringBuilder();

        while(n>0) {
            if(n%26==0) {
                sb.append('Z');
                n-=26;
            } else {
                int cur = n%26;
                sb.append((char)(cur-1+'A'));
            }
            n/=26;

        }

        return sb.reverse().toString();
    }
}
