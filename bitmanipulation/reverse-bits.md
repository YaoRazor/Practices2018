# Reverse Bits

This is a typical problem of bit manipulation. Personally I am not a big fan of this kind of algorithm question, because they are rarely used in reality. Anyway, back to the topic. Normally you would rely on Java's bit operator to handle this kind of problems like '&', '\|' and '^'. For Java, when do right shift, you want to use '&gt;&gt;&gt;' because it will pad '0' on the left when doing right shift. Basically that's it.

```text
    public int reverseBits(int n) {
        int result = 0;
        for(int i=0; i<32; i++) {
            result = result<<1;
            int currentBit = 1&n;
            result|=currentBit;
            n = n>>1;
        }
        return result;
    }
```

For the follow up question, "How do you handle it if you need to do this multiple times". For this kind of questions, normally you want to do some pre computation and store the result into a table for real-time look up. So we divide the number into 8 chunks, 4 bits each and precompute the reversed version of it and store it into an array.  We can divide the 32 bits into 4 chunks, 8 bits each too. Basically it is the same, you need to use a little bit more memory in exchange of some speed improvement, which might not be necessary though. 

```text
    public int reverseBits(int n) {

        // The index of the array is the original number and the value of the array is its reversed version.         
        int[] tb = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        int mask = 15;
        int ans = 0;
        
        for(int i=0; i<8; i++) { 
            ans = ans<<4;
            int tmp = tb[n&15];
            ans |= tmp;
            n = n>>>4;
        }
               
        return ans;       
    }
```

