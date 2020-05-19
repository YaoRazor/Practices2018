package ninechapter.binarysearch.optional;

public class TotalOccurrenceOfTarget {
    public int totalOccurrence(int[] A, int target) {
        int[] ans = searchRange(A, target);
        if(ans[0]==-1) {
            return 0;
        }

        return ans[1]-ans[0]+1;
    }


    public int[] searchRange(int[] A, int target) {
        int[] ans = new int[]{-1, -1};

        if (A == null || A.length == 0) {
            return ans;
        }

        int n = A.length;

        int start = 0;
        int end = n - 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;

            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (A[start] != target && A[end] != target) {
            return ans;
        }

        ans[0] = A[start] == target ? start : end;

        start = ans[0];
        end = n - 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;

            if (A[mid] > target) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }

        ans[1] = A[end] == target ? end : start;
        return ans;
    }
}
