package advanced.chaptertwo;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

// TC: 路径压缩后可以倾向于认为Union find的操作都是log*(n)或者O(1). 所以TC=0(N).
// N是operator的长度
public class NumberOfIslandsTwo {
    int[] father;

    private int find(int x) {
        int ans = x;
        while(father[ans]!=ans) {
            ans = father[ans];
        }

        while(father[x]!=ans) {
            int tmp = father[x];
            father[x] = ans;
            x = tmp;
        }

        return ans;
    }

    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        if(positions==null || positions.length==0) {
            return ans;
        }

        father = new int[m*n];
        for(int i=0; i<m*n; i++) {
            father[i] = i;
        }

        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for(int[] position: positions) {
            int x = position[0];
            int y = position[1];
            if(set.contains(x*n+y)) {
                ans.add(sum);
                continue;
            }

            sum++;
            set.add(x*n+y);

            for(int[] dir: dirs) {
                int newX = dir[0]+x;
                int newY = dir[1]+y;
                if(newX<0 || newX==m || newY<0 || newY==n || !set.contains(newX*n+newY)) {
                    continue;
                }

                // fx在这个过程中可能是一直变化的，所以不能放在外面
                int fx = find(x*n+y);
                int fy = find(newX*n+newY);
                if(fx!=fy) {
                    father[fx] = fy;
                    sum--;
                }
            }

            ans.add(sum);
        }

        return ans;
    }
}
