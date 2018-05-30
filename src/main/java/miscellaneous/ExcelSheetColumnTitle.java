package miscellaneous;


public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();


        while(n>0) {
            n--; //Minus one every time, this is the key to this problem
            char cur = (char) (n%26+'A');
            sb.append(cur);
            n = n/26;
        }

        return sb.reverse().toString();

    }
}
