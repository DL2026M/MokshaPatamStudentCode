import java.util.LinkedList;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: David Lutch
 *
 */

public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        int fewestRolls = 0;
        int currentNode = 0;
        int Node = 0;
        Queue<Integer> order = new LinkedList<Integer>();
        //int snake[] =


        // BFS is going to remove the first node and then see what are the possible places we can move
        order.add(1);
        while (!order.isEmpty()) {
            currentNode = order.remove();
            // Checking to see if we are at the end of the board
            if (currentNode == boardsize) {
                // Return the number of rolls
                return fewestRolls;
            }
            // Going through all the different dice roll possibilities
            for (int i = 1; i <= 6; i++) {
                // moves to the next node over
                Node = currentNode + i;
                // CHECK IF THE NODE IS A SNAKE OR A LADDER
                // FIGURE OUT A WAY TO KNOW HOW MANY ROLLS TO GET TO THE NODE WE ARE CURRENTLY VISITING
                // no clue how to save how many rolls we have used
                // whatever node that is visited I need to add it to the queue
            }
        }
        return 0;
    }
}
