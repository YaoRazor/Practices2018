package design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class DesignSnakeGame {
    Set<Integer>   set   = new HashSet<>();
    Deque<Integer> deque = new ArrayDeque<>();
    int[][]        food;
    int            width;
    int            height;
    int            score;
    int            foodIndex;

    public DesignSnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        set.add(0);
        deque.addLast(0);
        score = 0;
        foodIndex = 0;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {

        if (score == -1) {
            return -1;
        }

        int head = deque.peekFirst();
        int row = head/width;
        int col = head%width;

        switch(direction) {

            case "U": row--; break;
            case "L": col--; break;
            case "R": col++; break;
            case "D": row++; break;

            default: throw new RuntimeException();
        }

        // check boundary
        if(row>=height || row<0 || col>=width || col<0) {
            return -1;
        }

        // check whether eating itself
        int newHead = row*width+col;
        set.remove(deque.peekLast());
        if(set.contains(newHead)) {
            return -1;
        }

        deque.addFirst(newHead);
        set.add(newHead);



        if(foodIndex<food.length && row == food[foodIndex][0] && col ==food[foodIndex][1]) {
            score++;
            foodIndex++;
            set.add(deque.peekLast());
            return score;
        }


        deque.pollLast();
        return score;


    }
}
