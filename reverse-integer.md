# Reverse Integer

This is usually a warm-up question in the interview, besides logic implementation. Input checking, overflow checking are also critical for this kind of problems. 

For this question specifically,  we don't need to consider signs, but we need to cast the type to long and distinguish between Integer.MIN\_VALUE and Integer.MAX\_VALUE because they are different.

```text
    public int reverse(int x) {
        long ans = 0;
        while(x!=0) {
            ans = ans*10;
            ans += x%10;
            x = x/10;
        }

        if(ans>(long)Integer.MAX_VALUE || ans<(long)Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int)ans;
        }
    }
```

