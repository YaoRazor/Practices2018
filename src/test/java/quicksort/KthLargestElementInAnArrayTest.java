package quicksort;

import org.junit.Test;

public class KthLargestElementInAnArrayTest {


    @Test
    public void test() {

        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();


        int[] test = new int[] {3, 2, 1, 5, 6, 4};

//        int p = kthLargestElementInAnArray.partitionTwo(test, 0, 5);
        int p = kthLargestElementInAnArray.partition(test, 0, 5);

        return;




    }
}
