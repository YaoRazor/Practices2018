package miscellaneous;

public class IntegerToRoman {
    String[][] table= {{"", "I", "II", "III", "IV","V","VI","VII","VIII","IX"},
            {"", "X", "XX", "XXX", "XL","L","LX","LXX","LXXX","XC"},
            {"", "C", "CC", "CCC", "CD","D","DC","DCC","DCCC","CM"},
            {"", "M", "MM", "MMM", "", "", "", "", "", ""},};


    public String intToRoman(int num) {

        int i=0;
        String ans = "";

        while(num>0) {
            int cur = num%10;
            ans = table[i][cur] + ans;

            num/=10;
            i++;
        }

        return ans;

    }
}
