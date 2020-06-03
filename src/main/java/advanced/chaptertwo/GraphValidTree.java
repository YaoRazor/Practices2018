package advanced.chaptertwo;


// There is also solutions based on BFS and DFS
public class GraphValidTree {

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

    public boolean validTree(int n, int[][] edges) {
        if(n<=0 || edges==null || edges.length!=n-1) {
            return false;
        }

        UnionFind graph = new UnionFind(n);

        for(int[] edge: edges) {
            graph.union(edge[0], edge[1]);
        }

        return graph.getSum()==1;
    }
}
