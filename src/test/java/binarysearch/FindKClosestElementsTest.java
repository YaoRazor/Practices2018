package binarysearch;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindKClosestElementsTest {


    @Test
    public void test() {

        FindKClosestElements findKClosestElements = new FindKClosestElements();

        Integer[] testArray = new Integer[]{1, 3, 4, 5};

        List<Integer> testList = Arrays.asList(testArray);

        int index = Collections.binarySearch(testList, 2);

        System.out.println(index);
    }
}
