# First Unique Character in a String

Actually you can use sliding window to solve this problem using one pass..

```text
    public int firstUniqChar(String s) {       
        if(s==null || s.length()==0) {
            return -1;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        
        for(int j=0; i<s.length() && j<s.length(); j++) {
            
            char cur = s.charAt(j);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            
            while(i<=j) {                
                if(map.get(s.charAt(i))>1) {
                    i++;
                } else {
                    break;
                }      
            }               
        }
        
        if(i>=s.length()) {
            return -1;
        } else {
            return i;
        }        
    }
```

