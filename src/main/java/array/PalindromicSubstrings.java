package array;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if(s==null || s.length()==0) {
            return 0;
        }

        int n = s.length();

        boolean[][] isPalindrome = new boolean[n][n];
        int cnt = 0;


        for(int i=0; i<n; i++) {

            for(int j=0; j<=i; j++) {

                if((s.charAt(j)==s.charAt(i) && (i-j<2 || isPalindrome[j+1][i-1]))) {
                    isPalindrome[j][i] = true;
                    cnt++;
                }

            }

        }

        return cnt;

    }
}
