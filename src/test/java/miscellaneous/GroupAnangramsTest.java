package miscellaneous;

import org.junit.Test;

/**
 * Created by yawang on 4/18/18.
 */
public class GroupAnangramsTest {
    @Test
    public void test() {

        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

    }
}
