package slidingwindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new LinkedList<>();
        if (words.length == 0 || s.length() < words.length * words[0].length())   return ans;
        int n = s.length();
        int m = words.length;
        int wl = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String tmp : words) {
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }


        for(int i=0; i<wl; i++) {

            Map<String, Integer> curMap = new HashMap<>();
            int left = i;
            int count = 0;

            for(int right = i;right+wl<=n; right+=wl) {

                String subHi = s.substring(right, right+wl);

                if(!map.containsKey(subHi)) {
                    curMap.clear();
                    count = 0;
                    left = right+wl;

                } else {

                    curMap.put(subHi, curMap.getOrDefault(subHi, 0) + 1);
                    if(curMap.get(subHi)<=map.get(subHi)) {
                        // 只有curMap中的key是从<= map中的元素个数上升的时候才会影响count, 在下面50行是从<=map中下降的时候
                        // 才会影响count
                        count++;
                    }

                    // 每次都保证curMap中的subHi是小于等于map中的subHi，这样就可以确保没有一个元素是多于map中的对应的元素个数
                    // 结合count的定义，二者合在一起确保了有且只有对应words中的元素存在在[left, right)区间中。因为count总数
                    // 相等，又没有某一个元素是多于需要的个数的。那么说明words中的每一个元素都存在在现有子串中，而且数目也是
                    // 对应的
                    while(curMap.get(subHi) > map.get(subHi)) {
                        String subLo = s.substring(left, left+wl);
                        curMap.put(subLo, curMap.get(subLo)-1);

                        // subLo可以等于subHi，也可以不等于。只有curMap中的key是从<= map中的元素个数下降的时候才会影响count
                        if(curMap.get(subLo)<map.get(subLo)) {
                            count--;
                        }
                        left+=wl;
                    }

                    // count要达到的目标是words里的元素个数，注意这个count的定义，这是这里的一个关键点
                    if(count==m) {

                        ans.add(left);
                        String subLo = s.substring(left, left+wl);
                        curMap.put(subLo, map.get(subLo)-1);
                        count--;
                        left+=wl;
                    }

                }

            }

        }

        return ans;

    }
}
