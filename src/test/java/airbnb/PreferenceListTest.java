package airbnb;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreferenceListTest {


    @Test
    public void test() {


        PreferenceList preferenceList = new PreferenceList();
        List<Integer> list1 = new ArrayList<>(Arrays.asList(3, 5, 7, 9));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 3, 8));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(5,8));
        List<List<Integer>> input = new ArrayList<>();
        input.add(list1);
        input.add(list2);
        input.add(list3);


        System.out.println(preferenceList.getPreference(input));

    }
}
