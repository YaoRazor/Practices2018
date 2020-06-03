package advanced.chaptertwo;

public class ConnectingGraphTwo {

    class Point {
        int father;
        int sum;
        public Point(int father, int sum) {
            this.father = father;
            this.sum = sum;
        }
    }


    class UnionFind {

        Point[] father;

        public UnionFind(int n) {
            father = new Point[n+1];

            for(int i=1; i<=n; i++) {
                father[i] = new Point(i, 1);
            }
        }

        public Point find(int a) {
            int x = a;
            while(father[x].father!=x) {
                x = father[x].father;
            }

            while(father[a].father!=x) {
                int tmp = father[a].father;
                father[a].father = x;
                a = tmp;
            }

            return father[x];
        }

        public void union(int x, int y) {
            Point fx = find(x);
            Point fy = find(y);

            if(fx.father!=fy.father) {
                fx.father = fy.father;
                fy.sum+=fx.sum;
            }

        }

    }

    /*
     * @param n: An integer
     */

    private UnionFind graph;

    public ConnectingGraphTwo(int n) {
        graph = new UnionFind(n);
        // do intialization if necessary
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        graph.union(a, b);
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        return graph.find(a).sum;
    }
}
