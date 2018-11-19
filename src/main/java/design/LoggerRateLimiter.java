package design;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
    /** Initialize your data structure here. */

    Map<String, Integer> map = new HashMap<>();

    // 如果这是一个practical的问题，应该找到一个有ttl的数据结构，每一个entry只能存在最多10秒
    public boolean shouldPrintMessage(int timestamp, String message) {

        if(!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        } else {

            int lastTime = map.get(message);

            if(timestamp-lastTime>=10) {
                // 只有输出是true的时候才更新上次的timestamp
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }

        }

    }
}
