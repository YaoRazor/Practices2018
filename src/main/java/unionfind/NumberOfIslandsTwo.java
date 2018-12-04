package unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsTwo {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        List<Integer> ans = new ArrayList<>();

        if(positions==null || positions.length==0) {
            return ans;
        }

        int count = 0;
        int[] roots = new int[m*n];

        // 这一题上来先把root设成-1, 是因为后面只想计算本身值是1的值，对于本身值就不是1的位置，就没有必要采用union find算法了
        Arrays.fill(roots, -1);

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};


        for(int[] position: positions) {

            int root = n*position[0] + position[1];
            roots[root] = root;
            count++;

            for(int[] dir: dirs) {

                int dx = position[0]+dir[0];
                int dy = position[1]+dir[1];

                int neighbour = n*dx + dy;

                if(dx<0 || dx>=m || dy<0 || dy>=n || roots[neighbour]==-1) {
                    continue;
                }

                int rootOfNeighbour = find(roots, neighbour);

                if(rootOfNeighbour!=root) {
                    roots[root] = rootOfNeighbour;
                    root = rootOfNeighbour; //这一步很关键，就是保证后面都采用同一个root
                    count--;

                }

            }

            ans.add(count);

        }

        return ans;
    }


    private int find(int[] roots, int id) {
        while(id!=roots[id]) {
            roots[id] = roots[roots[id]]; //这里加一行相当于path compression，没有这一行也不影响逻辑
            id = roots[id];
        }

        return id;
    }
}
