package design;

public class ReadNCharsGivenRead4 extends Reader4{
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {

        char[] tmp =  new char[4];
        int start = 0;

        while(start<n) {

            int cur = read4(tmp);
            cur = Math.min(n-start, cur);

            for(int i=0; i<cur; i++) {
                buf[start++] = tmp[i];
            }

            if(cur<4) {
                break;
            }

        }

        return start;

    }


}

abstract class Reader4{

    int read4(char[] buf){
        return 0;
    }
}
