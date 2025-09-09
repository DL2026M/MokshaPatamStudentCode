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

        int[] snake = new int[boardsize + 1];
        int[] ladder = new int[boardsize + 1];
        int[] rollTracker = new int [boardsize + 1];
        // WRITE A COMMENT HERE TO EXPLAIN THIS
        for (int i = 0; i < ladders.length; i++) {
            ladder[ladders[i][0]] = ladders[i][1];
        }
        for (int i = 0; i < snakes.length; i++) {
            snake[snakes[i][0]] = snakes[i][1];
        }

        // BFS is going to remove the first node and then see what are the possible places we can move
        order.add(1);
        while (!order.isEmpty()) {
            currentNode = order.remove();
            // Checking to see if we are at the end of the board
            if (currentNode == boardsize) {
                // Return the number of rolls
                return rollTracker[currentNode];
            }
            // Going through all the different dice roll possibilities
            for (int i = 1; i <= 6; i++) {
                // moves to the next node over
                Node = currentNode + i;
                // Checks to see if the node isn't a snake
                if (Node <= boardsize) {
                    if (snake[Node] != 0) {
                        Node = snake[Node];
                    } else if (ladder[Node] != 0) {
                        Node = ladder[Node];
                    }
                    // Checking to see if the node has been visited
                    if (rollTracker[Node] == 0) {
                        rollTracker[Node] += rollTracker[currentNode] + 1;
                        order.add(Node);
                    }
                }
            }
        }
        return -1;
    }

}
