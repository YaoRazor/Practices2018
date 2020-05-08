package ninechapter.optional;

import java.util.*;

public class SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        List<Set<Integer>> nonZeroColA = new ArrayList<>();
        List<Set<Integer>> nonZeroRowB = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            Set<Integer> temp = new HashSet<>();
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    temp.add(j);
                }
            }
            nonZeroColA.add(temp);
        }

        for (int i = 0; i < B[0].length; i++) {
            Set<Integer> temp = new HashSet<>();
            for (int j = 0; j < B.length; j++) {
                if (B[j][i] != 0) {
                    temp.add(j);
                }
            }
            nonZeroRowB.add(temp);
        }

        for (int i = 0; i < nonZeroColA.size(); i++) {
            for (int j = 0; j < nonZeroRowB.size(); j++) {
                for (int aColInd: nonZeroColA.get(i)) {
                    if (nonZeroRowB.get(j).contains(aColInd)) {
                        result[i][j] += A[i][aColInd] * B[aColInd][j];
                    }
                }
            }
        }
        return result;
    }
}
