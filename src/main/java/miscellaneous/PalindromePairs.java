package miscellaneous;

import java.util.*;

public class PalindromePairs {

    // 这里给出的是HashMap的解法，本题还有采用Trie的解法，有空的时候可以看一下
    // 基本思想就是把字符拆成左中右三部分，只要中间是Palindrome, 那么只要能找到左边或者右边的reversed string那就可以了
    // 比方说abacde, aba已经是palindrome了，只要还有一个edc，那么就可以和现有string组成edcabacde这个parlindrome
    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> ans = new ArrayList<>();

        if(words==null || words.length==0) {
            return ans;
        }

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<words.length; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }


        for(int i=0; i< words.length; i++) {

            String cur = words[i];

            for(int j=0; j<=cur.length(); j++) {

                // substring(0, 0)是空字符串
                String left = cur.substring(0, j);
                String right = cur.substring(j);


                if(isPalindrome(left) && map.containsKey(right) && map.get(right)!=i) {

                    ans.add(Arrays.asList(map.get(right), i));

                }


                // right.length()!=0是用来防止互为reverse这种情况，比如对于abcd和dcba, 不会把abcddcba和dcbaabcd各计算两次
                if(isPalindrome(right) && map.containsKey(left) &&map.get(left)!=i && right.length()!=0) {
                    ans.add(Arrays.asList(i, map.get(left)));
                }


            }



        }

        return ans;
    }



    private boolean isPalindrome(final String s) {

        int i=0;
        int j= s.length()-1;
        while (i<j){

            if(s.charAt(i++)!=s.charAt(j--)) {
                return false;
            }

        }

        return true;
    }

}
