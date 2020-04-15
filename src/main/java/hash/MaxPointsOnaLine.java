package hash;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnaLine {

    public int maxPoints(int[][] points) {
        if(points==null) {
            return 0;
        }

        int n = points.length;
        if(n<=2) {
            return n;
        }

        int ans = 0;

        for(int i=0; i<n-1; i++) {

            Map<String, Integer> map = new HashMap<>();
            int x1 = points[i][0];
            int y1 = points[i][1];
            int dup = 1;
            int max = 0;

            for(int j=i+1; j<n; j++) {

                int x2 = points[j][0];
                int y2 = points[j][1];
                if(x2==x1 && y2==y1) {
                    dup++;
                    continue;
                }

                String slope = getSlope(x2-x1, y2-y1);
                map.put(slope, map.getOrDefault(slope, 0)+1);

                max = Math.max(max, map.get(slope));
            }

            ans = Math.max(ans, max+dup);
        }

        return ans;
    }

    private String getSlope(int dx, int dy) {
        int d = gcd(dx, dy);
        if(d!=0) {
            return dx/d+"," + dy/d;
        } else {
            return dx+","+dy;
        }
    }

    private int gcd(int a, int b) {
        return b==0? a: gcd(b, a%b);
    }
}
