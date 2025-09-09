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
        int currentNode = 0;
        int node = 0;
        Queue<Integer> order = new LinkedList<Integer>();
        // Maps created here
        int[] snake = new int[boardsize + 1];
        int[] ladder = new int[boardsize + 1];
        int[] rollTracker = new int [boardsize + 1];
        // Instead of going to a snake or ladder and then checking the surrounding nodes, you will automatically go
        // to the destination that the specific ladder or snake ends at
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
                // Moves to the next node over
                node = currentNode + i;
                // Checks to see if the node isn't a snake or a ladder
                if (node <= boardsize) {
                    if (snake[node] != 0) {
                        node = snake[node];
                    } else if (ladder[node] != 0) {
                        node = ladder[node];
                    }
                    // Checking to see if the node has been visited
                    if (rollTracker[node] == 0) {
                        rollTracker[node] += rollTracker[currentNode] + 1;
                        order.add(node);
                    }
                }
            }
        }
        // Returns -1 if there is no solution
        return -1;
    }

}
