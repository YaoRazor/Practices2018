package airbnb;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDIteratorWithRemoveTest {


    @Test
    public void test() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5));
        List<List<Integer>> vec2d = new ArrayList<>();
        vec2d.add(list1);
        vec2d.add(list2);
        //1,2
        //3
        TwoDIteratorWithRemove myIter = new TwoDIteratorWithRemove(vec2d);
        System.out.println(myIter.hasNext());
        System.out.println(myIter.next());
        System.out.println(myIter.hasNext());
        System.out.println(myIter.next());
        myIter.remove();
        System.out.println(myIter.next());
        for (int i = 0; i < vec2d.size(); i++) {
            if (vec2d.get(i) == null) continue;
            for (int j = 0; j < vec2d.get(i).size(); j++) {
                System.out.println("List" + i + ":" + vec2d.get(i).get(j));
            }

        }
        System.out.println(myIter.hasNext());
        System.out.println(myIter.next());

    }
}
