package array;


public class ReverseWordsInAStringTwo {
    public void reverseWords(char[] str) {
        if(str==null || str.length==0) {
            return;
        }

        reverse(str, 0, str.length-1);

        int start = 0;

        for(int i=0; i<str.length; i++) {
            if(str[i] ==' ') {
                reverse(str, start, i-1);
                start = i+1;
            }
        }

        reverse(str, start, str.length-1);
    }


    private void reverse(char[] str, int start, int end) {

       while (start<end) {

           char tmp = str[end];
           str[end] = str[start];
           str[start] = tmp;

           start++;
           end--;
       }
    }
}
