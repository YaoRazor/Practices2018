package design;

public class ReadNCharsGivenRead4 extends Reader4{
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean isEnd = false;
        char[] tmp = new char[4];
        int i = 0;

        while(!isEnd && i<n) {
            int cur = read4(tmp);
            if(cur<4) {
                isEnd = true;
            }

            for(int j=0; j<cur && i<n; ) {
                buf[i++] = tmp[j++];
            }
        }

        return i;
    }
}

abstract class Reader4{
    int read4(char[] buf){
        return 0;
    }
}
