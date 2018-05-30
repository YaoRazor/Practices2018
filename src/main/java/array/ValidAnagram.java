package array;

//比较常见的方法是sorting, 不过应为只有字母，所以可以
//使用26位的数组，不过可能直接使用Hashtable更straitforward一点
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null) {
            return false;
        }

        if(s.length()!=t.length()) {
            return false;
        }

        int[] count = new int[26];


        for(int i=0; i<s.length(); i++) {
            int tmp = (s.charAt(i)-'a');
            count[tmp]++;
        }


        for(int i=0; i<t.length(); i++) {
            int tmp = (t.charAt(i)-'a');
            count[tmp]--;
            if(count[tmp]<0) {
                return false;
            }
        }

        return true;

    }
}
