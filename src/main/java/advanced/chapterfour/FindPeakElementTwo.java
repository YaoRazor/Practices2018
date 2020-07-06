package advanced.chapterfour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPeakElementTwo {

    // TC: O(n*logm)
    public List<Integer> findPeakII(int[][] A) {
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = A.length-1;

        while(start<=end) {
            int mid = (start+end)/2;
            int col = findLocalMaximum(A[mid]);

            if(A[mid][col]>A[mid+1][col] && A[mid][col]>A[mid-1][col]) {
                ans.add(mid);
                ans.add(col);
                break;
            } else if(A[mid][col]<A[mid+1][col]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return ans;
    }

    private int findLocalMaximum(int[] A) {
        int ans = 0;

        for(int i=1; i<A.length; i++) {
            if(A[i]>A[ans]) {
                ans = i;
            }
        }

        return ans;
    }


    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // TC: O(n+m)，key point one: 每次找到相交的两条中线里面的最大值，然后把矩阵切成四块，然后进去一个子块
    public List<Integer> findPeakIIOptimized(int[][] A) {
        // key point two: from 1 to A.length-2
        return helper(A, 1,A.length - 2, 1, A[0].length - 2);
    }

    private List<Integer> helper(int[][] A, int x1, int x2, int y1, int y2) {
        // 这一题的base case是x1==x2, y1==y2, 但是还是需要在两条对角线上找到最大值，不能直接
        // 找到最大值
        int max = Integer.MIN_VALUE;

        int midX = (x1+x2)/2;
        int midY = (y1+y2)/2;
        int x = midX;
        int y = midY;

        for(int i=y1; i<=y2; i++) {
            if(A[midX][i]>max) {
                max = A[midX][i];
                y = i;
            }
        }

        for(int i=x1; i<=x2; i++) {
            if(A[i][midY]>max) {
                max = A[i][midY];
                x = i;
                y = midY;
            }
        }

        boolean isMax = true;

        for(int[] dir: dirs) {
            int newX = x+dir[0];
            int newY = y +dir[1];

            if(A[newX][newY]>max) {
                isMax = false;
                x = newX;
                y = newY;
                break;
            }
        }

        if(isMax) {
            return Arrays.asList(x, y);
        }

        if(x<midX && y<midY) {
            return helper(A, x1, midX-1, y1, midY-1);
        } else if(x<midX && y>midY) {
            return helper(A, x1, midX-1, midY+1, y2);
        } else if(x>midX && y<midY) {
            return helper(A, midX+1, x2, y1, midY-1);
        } else {
            return helper(A, midX+1, x2, midY+1, y2);
        }
    }
}
