package airbnb;

import java.util.ArrayList;
import java.util.List;


// This method can not handle the case that ip starts with "0.0.0.0"
public class IPToCIDR {
    public List<String> ipToCIDR(String ip, int n) {
        long start = ipToLong(ip);
        List<String> ans = new ArrayList<>();

        while (n>0) {
            System.out.println(start);
            System.out.println(n);
            long currentLength = Math.min(Long.lowestOneBit(start),Long.highestOneBit(n));
            int mask = 32- Long.numberOfTrailingZeros(currentLength); // 33 is a keypoint here
            ans.add(LongToIp(start)+"/"+mask);
            start+= 1<< (32-mask);
            n-= 1<<(32-mask);

        }

        return ans;

    }


    protected String LongToIp(long start) {
        return String.format("%s.%s.%s.%s", (start>>24)%256, (start>>16)%256, (start>>8)%256, start %256);
    }

    protected long ipToLong(final String ip) {

        long ans = 0;
        for(String s : ip.split("\\.")) {

            ans= ans*256+Integer.parseInt(s);

        }
        return ans;
    }

}
