package leetCodeProblems;

import java.util.BitSet;
import java.util.Scanner;

public class MinMoves {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[] classroom = new String[rows];

        for (int i = 0; i < rows; i++) {
            classroom[i] = scanner.next();
        }

        int energy = scanner.nextInt();

        int answer = minMoves(classroom, energy);

        System.out.println(answer);

        scanner.close();
    }

    public static int minMoves(String[] classroom, int energy) {
        int rows = classroom.length;
        int cols = classroom[0].length();
        int totalCells = rows * cols;

        int startRow = -1;
        int startCol = -1;
        int litterCount = 0;

        /*
         * litterIndex[row][col] gives the bit position assigned
         * to that litter cell.
         */
        int[][] litterIndex = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                litterIndex[row][col] = -1;
            }
        }

        // Find S and assign one bit to every L cell.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char cell = classroom[row].charAt(col);

                if (cell == 'S') {
                    startRow = row;
                    startCol = col;
                } else if (cell == 'L') {
                    litterIndex[row][col] = litterCount;
                    litterCount++;
                }
            }
        }

        // If there is no litter, no movement is required.
        if (litterCount == 0) {
            return 0;
        }

        int allLitterMask = (1 << litterCount) - 1;
        int maskCount = 1 << litterCount;
        int energyStates = energy + 1;

        /*
         * Total possible states:
         *
         * collectedLitterMask
         * × grid position
         * × remaining energy
         */
        int totalStates = maskCount * totalCells * energyStates;

        BitSet visited = new BitSet(totalStates);

        /*
         * Primitive integer queue.
         *
         * Each state is encoded as:
         * ((mask * totalCells + position) * energyStates + remainingEnergy)
         */
        int[] queue = new int[totalStates];

        int front = 0;
        int back = 0;

        int startPosition = startRow * cols + startCol;

        int startState = encode(
                0,
                startPosition,
                energy,
                totalCells,
                energyStates
        );

        visited.set(startState);
        queue[back++] = startState;

        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        int moves = 0;

        while (front < back) {
            int levelSize = back - front;

            /*
             * Process one BFS level at a time.
             * Every state in this level has used exactly "moves" moves.
             */
            for (int i = 0; i < levelSize; i++) {
                int encodedState = queue[front++];

                int remainingEnergy = encodedState % energyStates;
                encodedState /= energyStates;

                int position = encodedState % totalCells;
                int collectedMask = encodedState / totalCells;

                int row = position / cols;
                int col = position % cols;

                /*
                 * With zero energy, the student cannot make another move.
                 *
                 * If this node were R, energy would already have been
                 * restored when the student entered it.
                 */
                if (remainingEnergy == 0) {
                    continue;
                }

                for (int[] direction : directions) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];

                    if (nextRow < 0 || nextRow >= rows ||
                            nextCol < 0 || nextCol >= cols) {
                        continue;
                    }

                    char nextCell = classroom[nextRow].charAt(nextCol);

                    // Cannot pass through an obstacle.
                    if (nextCell == 'X') {
                        continue;
                    }

                    int nextEnergy = remainingEnergy - 1;
                    int nextMask = collectedMask;

                    // Collect litter if entering an L cell.
                    if (nextCell == 'L') {
                        int litterBit = litterIndex[nextRow][nextCol];
                        nextMask |= (1 << litterBit);
                    }

                    // Reset energy if entering an R cell.
                    if (nextCell == 'R') {
                        nextEnergy = energy;
                    }

                    // Since this is BFS, the first full-mask state is optimal.
                    if (nextMask == allLitterMask) {
                        return moves + 1;
                    }

                    int nextPosition = nextRow * cols + nextCol;

                    int nextState = encode(
                            nextMask,
                            nextPosition,
                            nextEnergy,
                            totalCells,
                            energyStates
                    );

                    if (!visited.get(nextState)) {
                        visited.set(nextState);
                        queue[back++] = nextState;
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private static int encode(
            int collectedMask,
            int position,
            int remainingEnergy,
            int totalCells,
            int energyStates
    ) {
        return ((collectedMask * totalCells + position) * energyStates)
                + remainingEnergy;
    }
}