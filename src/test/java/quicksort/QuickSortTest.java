package quicksort;

import org.junit.Test;

public class QuickSortTest {


    @Test
    public void test() {
        int[] test = new int[] {3, 2, 1, 5, 6, 4};

        QuickSort quickSort = new QuickSort();

        quickSort.quickSort(test);

        return;
    }
}
