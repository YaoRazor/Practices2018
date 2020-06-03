package advanced.chaptertwo;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class NumberOfIslandsTwo {

  class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }

    class UnionFind {
        int[] father;
        int sum;

        UnionFind(int n) {
            father = new int[n+1];

            for(int i=1; i<=n; i++) {
                father[i] = i;
            }

            sum = 0;
        }

        int find(int a) {
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

        void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);

            if(fx!=fy) {
                father[fx] = fy;
                this.sum--;
            }
        }
    }

    private UnionFind graph;
    int[][] dirs = new int[][]{{0,1}, {0, -1}, {1,0}, {-1, 0}};

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        Set<Integer> set = new HashSet<>();

        List<Integer> ans = new ArrayList<>();
        if(operators==null || operators.length==0 || n<=0 || m<=0) {
            return ans;
        }


        graph = new UnionFind(n*m);

        for(Point point: operators) {
            int cur = point.x*m+point.y;
            if(set.contains(cur)) {
                ans.add(graph.sum);
                continue;
            }

            set.add(cur);
            graph.sum++;

            for(int[] dir: dirs) {
                int x = point.x + dir[0];
                int y = point.y + dir[1];

                if(x<0 || x>=n || y<0 || y>=m) {
                    continue;
                }

                int tmp = x*m+y;
                if(!set.contains(tmp)) {
                    continue;
                }

                graph.union(tmp, cur);
            }

            ans.add(graph.sum);
        }

        return ans;
    }
}
