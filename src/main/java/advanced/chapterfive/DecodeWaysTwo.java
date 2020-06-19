package advanced.chapterfive;

public class DecodeWaysTwo {

    // TC:O(N), SC: O(1) using rolling array optimization
    public int numDecodings(String s) {
        if(s==null || s.length()==0) {
            return 0;
        }

        int n = s.length();
        long[] dp = new long[3];
        dp[0] = 1;
        dp[1] = countNminusOne(1, s);

        long mod = 1000000007;

        for(int i=2; i<=n; i++) {
            dp[i%3] = countNminusOne(i, s)*dp[(i-1)%3] + countNminusTwo(i, s)*dp[(i-2)%3];
            dp[i%3]%=mod;
        }

        return (int)dp[n%3];
    }

    private long countNminusOne(int i, String s) {
        char c = s.charAt(i-1);
        if(c=='0') {
            return 0;
        } else if(c=='*') {
            return 9;
        } else {
            return 1;
        }
    }

    private long countNminusTwo(int i, String s) {
        char high = s.charAt(i-2);
        char low = s.charAt(i-1);
        if(high=='0') {
            return 0;
        } else if(high=='1') {
            if(low=='*') {
                return 9;
            } else {
                return 1;
            }
        } else if(high=='2') {
            if(low=='*') {
                return 6;
            } else {
                if(low=='7' || low=='8' || low=='9') {
                    return 0;
                } else {
                    return 1;
                }
            }
        } else if(high=='*') {
            if(low=='*') {
                return 15;
            }

            if(low=='7' || low=='8' || low=='9') {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }
}
