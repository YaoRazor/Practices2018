package airbnb;

import org.junit.Test;

public class HouseRobberTest {

    @Test
    public void test() {
        HouseRobber hr = new HouseRobber();
        int[] nums1 = {3, 5, 6, 1, 2, 4, 1};
        System.out.println("Max: "+hr.robAirbnb(nums1));
        int[] nums2 = {5, 2, 4, 7, 3, 1};
        System.out.println("Max: "+hr.robAirbnb(nums2));
    }
}
