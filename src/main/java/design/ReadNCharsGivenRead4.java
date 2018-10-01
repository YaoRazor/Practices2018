package design;

public class ReadNCharsGivenRead4 extends Reader4{
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {

        char[] tmp = new char[4];
        int i = 0;
        int len = 0;

        while(i<n && (len=read4(tmp))>0) {


            len = Math.min(len, n-i);
            System.arraycopy(tmp /* src */, 0 /* srcPos */,
                    buf /* dest */, i /* destPos */, len /* length */);

            i+=len;

        }

        return i;

    }


}

abstract class Reader4{

    int read4(char[] buf){
        return 0;
    }
}
