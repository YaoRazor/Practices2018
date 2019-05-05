package airbnb;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WizardShortestDistanceTest {



    @Test
    public void test() {

        WizardShortestDistance wsd = new WizardShortestDistance();
        int[][] ids = {{1, 5, 9}, {2, 3, 9}, {4}, {}, {}, {9}, {}, {}, {}, {}};
        List<List<Integer>> wizards = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            List<Integer> wizard = new ArrayList<>();
            for (int j = 0; j < ids[i].length; j++) {
                wizard.add(ids[i][j]);
            }
            wizards.add(wizard);
        }

        System.out.println(wsd.getShortestPath(wizards, 0, 9));

//        WizardShortestDistance wizardShortestDistance = new WizardShortestDistance();
//
//        w

    }
}
