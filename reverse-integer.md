---
description: >-
  For questions related to numeric value, usually you need to consider two edge
  cases: 1. it is positive or negative, another thing is how to handle overflow.
---

# Reverse Integer && String to Integer \(atoi\)

## Reverse Integer

This is usually a warm-up question in the interview, besides logic implementation. Input checking, overflow checking are also critical for this kind of problems. 

For this question specifically,  we don't need to consider signs

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

## String to Integer \(atoi\)

```text
class Solution {
    public int myAtoi(String str) {
        if(str==null || str.length()==0) {
            return 0;
        }

        int i=0;

        // Remove leading zeroes
        while(i<str.length()) {
            if(str.charAt(i)==' ') {
                i++;
            } else {
                break;
            }
        }
        
        // Check whether it has reached the end
        if(i>=str.length()) {
            return 0;
        }

        return parseInt(str, i);
    }

    private int parseInt(String s, int i) {
        boolean isNegative = false;
        long ans = 0;

        // Check sign
        if(s.charAt(i)=='-' || s.charAt(i)=='+') {
            isNegative = s.charAt(i)=='-'? true: false;
            i++;
        }

        // Check number
        for(; i<s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                ans = ans*10 + (s.charAt(i)-'0');
                // Handle overflow
                if(ans> (long)Integer.MAX_VALUE) {
                    break;
                }
            } else {
                break;
            }

        }

        ans = isNegative? -ans: ans;

        if(ans<Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if(ans>Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int)ans;
        }
    }
}
```



