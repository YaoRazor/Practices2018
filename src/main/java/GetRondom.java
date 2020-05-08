import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GetRondom {

    private static Integer[] optional_problems= {
            1790, 667, 841, 594,
            242, 788, 787, 624, 618, 598, 531, 178, 431, 71, 70, 892, 794,
            462, 459, 235, 254, 28, 14, 414, 61, 38, 600, 65,
            1311, 597, 376, 474, 246, 155, 97, 68, 67, 66, 915, 448, 88, 472,
            604, 56, 1375, 609, 587, 533, 443, 461, 382, 148, 59,
            652, 570, 535, 426, 427, 10, 152, 16, 802, 780,
            495, 128, 685, 613, 606, 601, 545, 526, 486, 130, 129, 124,
            476, 190, 198, 197, 52, 51, 634,
            272, 515, 151, 117, 116, 622,

    };

    private static Integer[] optional_solved_problems = {
            515, 545, 495, 254, 448, 915, 618, 197, 198, 148
    };


    public static void main(String args[]) {
        Set<Integer> problemsToSolve = new HashSet<>(Arrays.asList(optional_problems));
        Set<Integer> solvedProblems = new HashSet<>(Arrays.asList(optional_solved_problems));

        problemsToSolve.removeAll(solvedProblems);

        List<Integer> ans = new ArrayList<>(problemsToSolve);

        Random random = new Random();
        int index = random.nextInt(ans.size());
        System.out.println("You need to solve problem: " + ans.get(index));
    }
}
