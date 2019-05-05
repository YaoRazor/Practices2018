package design;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yawang on 5/31/18.
 */
public class ShuffleAnArray {

    private int[] nums;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {


        int[] newArray = nums.clone();

        for(int i=0; i<newArray.length; i++) {

            int index = getRand(i, newArray.length);

            int tmp = newArray[index];
            newArray[index] = newArray[i];
            newArray[i] = tmp;
        }

        return newArray;

    }


    private int getRand(int min, int max) {
        return new Random().nextInt(max-min) + min;
    }

}
