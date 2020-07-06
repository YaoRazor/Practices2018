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

        UnionFind(int n) {
            father = new int[n+1];
            for(int i=1; i<=n; i++) {
                father[i] = i;
            }
        }

        private void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);

            if(fx!=fy) {
                father[fx] = fy;
            }
        }

        private int find(int x) {
            int tmp = x;
            while(father[x]!=x) {
                x = father[x];
            }

            while(father[tmp]!=x) {
                int a = father[tmp];
                father[tmp] = x;
                tmp = a;
            }

            return x;
        }

    }

    int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1, 0}};

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> ans = new ArrayList<>();
        if(operators==null || operators.length==0) {
            return ans;
        }

        // track which points are 1
        Set<Integer> set = new HashSet<>();
        UnionFind unionFind = new UnionFind(n*m);
        int cnt = 0;

        for(Point point: operators) {
            int x = point.x;
            int y = point.y;

            // prevent duplicated input
            if(set.contains(x*m+y)) {
                ans.add(cnt);
                continue;
            }

            cnt++;
            int cur = x*m+y;
            set.add(cur);

            for(int[] dir: dirs) {
                int nx = x+dir[0];
                int ny = y+dir[1];

                if(nx<0 || nx>=n || ny<0 || ny>=m || !set.contains(nx*m+ny)) {
                    continue;
                }

                int fx = unionFind.find(cur);
                int fy = unionFind.find(nx*m+ny);
                if(fx!=fy) {
                    unionFind.union(cur, nx*m+ny);
                    cnt--;
                }

            }

            ans.add(cnt);
        }

        return ans;
    }
}
