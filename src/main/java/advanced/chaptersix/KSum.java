package advanced.chaptersix;

public class KSum {

    // TC: O(n*k*target)
    // 三维数组就想象成一个坐标轴，后两维是平面，最前一维是纵轴
    public int kSum(int[] A, int k, int target) {
        if(A==null || A.length<k) {
            return 0;
        }

        int n = A.length;
        int[][][] f = new int[n + 1][k + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {
            f[i][0][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    f[i][j][t] = f[i - 1][j][t];
                    if (t >= A[i - 1]) {
                        f[i][j][t] += f[i - 1][j - 1][t - A[i - 1]];
                    }
                } // for t
            } // for j
        } // for i
        return f[n][k][target];
    }
}
