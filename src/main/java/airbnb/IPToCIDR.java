package airbnb;

import java.util.ArrayList;
import java.util.List;


// This method can not handle the case that ip starts with "0.0.0.0"
public class IPToCIDR {
    public List<String> ipToCIDR(String ip, int n) {
        long start = ipToLong(ip);
        List<String> ans = new ArrayList<>();

        while (n>0) {

            long step = start & -start;
            while (step> n) {
                step/=2;
            }

            ans.add(LongToIp(start, step));

            start+=step;
            n-=step;
        }

        return ans;

    }

    protected String LongToIp(long start, long step) {

        int key = 33;

        while(step>0) {
            key--;
            step/=2;
        }

        return String.format("%s.%s.%s.%s", (start>>24)&255, (start>>16)&255, (start>>8)&255, start&255) + "/" + key;
    }

    protected long ipToLong(final String ip) {

        long ans = 0;
        for(String s : ip.split("\\.")) {
            ans= ans*256+Integer.parseInt(s);
        }
        return ans;
    }
}
