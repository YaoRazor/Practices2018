package companies.amazon;

import org.junit.Test;

public class MazeMinStepsTest {


    @Test
    public void test() {

        MazeMinSteps sol = new MazeMinSteps();
        int[][] maze = {
                {0, 1, 1, 1, 1},
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0}
        };

        System.out.println(sol.minSteps(maze, 4, 4));

        int[][] maze2 = {
                {0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0}
        };

        System.out.println(sol.minSteps(maze2, 0, 4));

        int[][] mazeNoPath = {
                {0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0}
        };

        System.out.println(sol.minSteps(mazeNoPath, 4, 3));

        MazeMinSteps mazeMinSteps = new MazeMinSteps();



    }
}
