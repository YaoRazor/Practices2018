package advanced.chaptertwo;

public class ConnectingGraphThree {

    class UnionFind {
        int[] father;
        int sum;

        public UnionFind(int n) {
            father = new int[n+1];

            for(int i=1; i<=n; i++) {
                father[i] = i;
            }

            sum = n;
        }

        public int getSum() {
            return this.sum;
        }

        public int find(int a) {
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

        public void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);

            if(fx!=fy) {
                father[fx] = fy;
                this.sum--;
            }
        }
    }

    private UnionFind graph;

    public ConnectingGraphThree(int n) {
        graph = new UnionFind(n);
        // initialize your data structure here.
    }

    public void connect(int a, int b) {
        graph.union(a, b);
        // write your code here
    }

    /**
     * @return: An integer
     */
    public int query() {

        return graph.getSum();
        // write your code here
    }
}
