package ninechapter.hash_and_heap.optional;

public class HashFunction {
    // (a*b)%c = ((a%c) * (b%c)) % c
    // (a+b)%c = a%c + b%c
    public int hashCode(char[] key, int HASH_SIZE) {
        if(key==null || key.length==0) {
            return 0;
        }

        long hash = 0;

        for(char c: key) {
            hash = hash*(33%HASH_SIZE)+c;
            hash%=HASH_SIZE;
        }

        return (int)hash;
    }
}
