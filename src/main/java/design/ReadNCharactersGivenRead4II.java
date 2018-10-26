package design;

public class ReadNCharactersGivenRead4II extends Reader4{
    char[] buffer = new char[4];
    private int buffPtr=0;
    private int bufCnt=0;

    public int read(char[] buf, int n) {

        int ptr = 0;

        while (ptr<n) {
            if(buffPtr==bufCnt) {
                bufCnt = read4(buffer);
                if(bufCnt==0) {
                    buffPtr = 0;
                    break;
                }
                buffPtr = 0;
            }

            buf[ptr++] = buffer[buffPtr++];
        }

        return ptr;
    }
}
