package advanced.chaptertwo;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

// TC: 路径压缩后可以倾向于认为Union find的操作都是log*(n)或者O(1). 所以TC=0(N).
// N是operator的长度
public class NumberOfIslandsTwo {
    private int[] father;

    private int find(int x) {
        int ans = x;
        while(father[ans]!=ans) {
            ans = father[ans];
        }

        int tmp = x;
        while(father[tmp]!=ans) {
            int next = father[tmp];
            father[tmp] = ans;
            tmp = next;
        }

        return ans;
    }

    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int cnt = 0;
        father = new int[m*n];
        for(int i=0; i<m*n; i++) {
            father[i] = i;
        }

        Set<Integer> visited = new HashSet<>();

        for(int[] position: positions) {
            int x = position[0];
            int y = position[1];

            if(visited.contains(x*n+y)) {
                ans.add(cnt);
                continue;
            }

            cnt++;
            visited.add(x*n+y);

            for(int[] dir: dirs) {
                int newX = x+dir[0];
                int newY = y+dir[1];

                if(newX<0 || newX==m || newY<0 || newY==n || !visited.contains(newX*n+newY)) {
                    continue;
                }

                // 这一句不能提到外面去，因为fx在这个循环中是可能一直在变化的
                int fx = find(x*n+y);
                int fy = find(newX*n+newY);

                if(fx!=fy) {
                    cnt--;
                    father[fx] = fy;
                }
            }
            ans.add(cnt);
        }

        return ans;
    }
}
