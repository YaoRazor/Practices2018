package design;

public class ReadNCharactersGivenRead4II extends Reader4{
    private char[] buf4 = new char[4];

    // Because we will need to use this function a couple of times,
    // therefore we need to keep two state: buffPtr and bufCnt here

    // historic position in buf4
    private int buffPtr = 0;
    // number of characters read last time
    private int bufCnt = 0;

    public int read(char[] buf, int n) {
        int cnt = 0;

        while(cnt<n) {
            // either buffPtr and bufCnt are both zero, which means
            // it is the first time to use this method. Or we have
            // used up the characters we read last time
            if(buffPtr==bufCnt) {
                buffPtr = 0;
                bufCnt = read4(buf4);
                if(bufCnt==0) {
                    break;
                }
            }

            // For the simplest case, we can remove this while loop and
            // only keep line "buf[cnt++] = buf4[buffPtr++];. We keep this while loop to make the
            // code more intuitive
            while(cnt<n && buffPtr<bufCnt) {
                buf[cnt++] = buf4[buffPtr++];
            }
        }

        return cnt;
    }
}
