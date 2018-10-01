package twodimensionarray;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {

        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) {
            return new int[0];
        }


        int m = matrix[0].length;
        int n = matrix.length;

        int[] ans = new int[m*n];

        int index = 0;


        for(int i=0; i<m+n; i++) {

            int row = Math.min(i, m-1);
            int col = Math.min(i, n-1);

            if(i%2==1) {


                // j+k = i
                int k = col;
                int j = i-col;

                while (j<=row && k>=0) {
                    ans[index++] = matrix[j++][k--];
                }

            } else {

                //j+k = i
                int j=row;
                int k = i-row;

                while (j>=0 && k<=col) {
                    ans[index++] = matrix[j--][k++];
                }
            }

        }

        return ans;

    }

}
