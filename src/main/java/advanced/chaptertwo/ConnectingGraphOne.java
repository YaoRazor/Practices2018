package advanced.chaptertwo;

public class ConnectingGraphOne {

    int[] father;
    /*
     * @param n: An integer
     */public ConnectingGraphOne(int n) {
        father = new int[n+1];
        for(int i=1; i<=n; i++) {
            father[i] = i;
        }
        // do intialization if necessary
    }

    private int find(int a) {
        int x = a;
        while(father[x]!=x) {
            x = father[x];
        }

        while(father[a]!=x) {
            int tmp = father[a];
            father[a] = x;
            a = tmp;
        }

        return x;
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if(fa!=fb) {
            father[fa] = fb;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        return fa==fb;
    }
}
