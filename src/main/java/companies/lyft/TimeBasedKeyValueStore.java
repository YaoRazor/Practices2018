package companies.lyft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
    class Data {
        String value;
        int timestamp;
        Data(final String value, final int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Data>> map;


    /** Initialize your data structure here. */
    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        } else {
            List<Data> list = map.get(key);
            int left = 0;
            int right = list.size()-1;

            while(left+1<right) {
                int mid = (left+right)/2;
                if(list.get(mid).timestamp==timestamp) {
                    return list.get(mid).value;
                } else if(list.get(mid).timestamp<timestamp) {
                    left = mid;
                } else {
                    right = mid-1;
                }
            }

            if(list.get(right).timestamp<=timestamp) {
                return list.get(right).value;
            } else if(list.get(left).timestamp>timestamp){
                return "";
            } else {
                return list.get(left).value;
            }
        }

    }
}
