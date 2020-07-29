import ninechapter.warmup.optional.StrStrTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

// Leader: FrogJump
// inorder traversal
public class GetRondom {

    private static Integer[] ladder_4_optional = {
                    609,
                    461,
                    382,
                    32,
                    5,
                    543,
                    559,
                    477,
                    432,
                    431,
                    635,
                    634,
                    475,
                    370,
                    369,
                    130,
                    40,
                    12,
                    623,
                    510,
                    367,
                    368,
                    126,
                    122,
                    821,
                    75,
                    74,
                    600,
                    131,
                    631,
                    581,
                    393,
                    435,
                    396,
                    564,
                    563,
                    562,
                    440,
                    393,
                    118,
                    91,
                    29,
                    168,
                    551,
                    601,
                    574,
                    553,
                    541,
                    540,
                    404,
                    573,
                    390
    };

    private static Integer[] ladder1_relatecd= {
            574, 434, 600,
            457, 141, 617, 586, 437, 160, 63, 183,
            595, 619 ,614 ,520 ,475 ,94,
            894, 625, 610, 380, 102, 58, 103,
            196,
            551, 494, 575, 541, 540, 528, 471, 224, 24,
            828, 211, 123,
            254, 630, 584,
            41, 620, 617, 404, 393, 191, 151, 150, 45, 42, 43
    };

    private static Integer[] optional_and_related_solved_problems = {
           75, 393, 559, 475, 94, 461, 5, 123, 595, 553,
           404, 183, 540, 541, 40, 434, 601, 196, 431, 432,
           168, 118, 477, 396, 32, 543, 29, 609, 382, 122,
           510, 821, 574, 551, 600, 74, 91, 440, 563, 12,
           562, 564, 614, 619, 581, 130, 126, 631, 634, 390,
           160, 254, 41, 437, 45, 132, 573, 828, 211, 625,
           141, 380, 150, 102, 617, 224
    };

    private static Integer[] optional_problems= {
            1790, 667, 841, 594,
            242, 788, 787, 624, 618, 598, 531, 178, 431, 71, 70, 892, 794, 573,
            462, 459, 235, 254, 28, 14, 414, 61, 38, 600, 65,
            1311, 597, 376, 474, 246, 155, 97, 68, 67, 66, 915, 448, 88, 472,
            604, 56, 1375, 609, 587, 533, 443, 461, 382, 148, 59,
            652, 570, 535, 426, 427, 10, 152, 16, 802, 780,
            495, 128, 685, 613, 606, 601, 545, 526, 486, 130, 129, 124,
            476, 190, 198, 197, 52, 51, 634,
            272, 515, 151, 117, 116, 622,
            931
    };

    private static Integer[] optional_solved_problems = {
            515, 545, 495, 254, 448, 915, 618, 197, 198, 148,
            652, 609, 151, 52, 155, 613, 190, 474, 124, 117,
            116, 598, 431, 128, 382, 622, 88, 16, 61, 59,
            235, 427, 462, 68, 66, 67, 1311, 570, 376, 246,
            587, 1375, 28, 38, 461, 242, 667, 476, 14, 624,
            178, 272, 685, 526, 780, 601, 51, 426, 597, 97,
            634, 459, 443, 604, 535, 56, 892, 71, 152, 414,
            70, 531, 606, 486, 794, 802, 129, 65, 1790, 533,
            130, 594, 787, 788, 600, 594, 841, 10, 573, 472,
            931
    };

    public static void main(String args[]) {
          Set<Integer> problemsToSolve = new HashSet<>(Arrays.asList(ladder_4_optional));
          problemsToSolve.addAll(Arrays.asList(ladder1_relatecd));
          Set<Integer> solvedProblems = new HashSet<>(Arrays.asList(optional_and_related_solved_problems));

          problemsToSolve.removeAll(solvedProblems);
          List<Integer> ans = new ArrayList<>(problemsToSolve);

          Random random = new Random();
          int index = random.nextInt(ans.size());
          System.out.println("You need to solve problem: " + ans.get(index));
          System.out.println("Left problems cnt: "+ans.size());

//        StrStrTwo strStrTwo = new StrStrTwo();
//        String test = "abcd";
//        System.out.println(strStrTwo.strStr2(test,"abc"));
//
//
//        Set<Integer> problemsToSolve = new HashSet<>(Arrays.asList(optional_problems));
//        Set<Integer> solvedProblems = new HashSet<>(Arrays.asList(optional_solved_problems));
//
//        System.out.println("Total problems cnt: "+ problemsToSolve.size());
//        System.out.println("Solved problems cnt: "+ solvedProblems.size());
//
//        problemsToSolve.removeAll(solvedProblems);
//
//        List<Integer> ans = new ArrayList<>(problemsToSolve);
//        System.out.println("Left problems cnt: "+ans.size());
//
//        Random random = new Random();
//        int index = random.nextInt(ans.size());
//        System.out.println("You need to solve problem: " + ans.get(index));
    }
}
