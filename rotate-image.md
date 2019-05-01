# Rotate Image

Just Remember this method, no need to think too much on this:

```text
/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/
```

```text
/*
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
*/
```

```text
    public void rotate(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<n; i++) {

            int start = 0;
            int end = m-1;

            while(start<end) {
                swap(matrix, start, i, end, i);
                start++;
                end--;
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=i+1; j<n; j++) {
                swap(matrix, i, j, j, i);
            }
        }

    }

    private void swap(int[][] matrix, int i, int j, int n, int k) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[n][k];
        matrix[n][k] = tmp;
    }
```

