public class PracticeProblem {

    public static void main(String args[]) {

    }

    public static int searchMazeMoves(String[][] arr) {
		// Directly call the helper function with the starting row, col, and initial moves
		return searchMazeMovesHelper(arr, arr.length - 1, 0, 0);

    }

    public static int searchMazeMovesHelper(String[][] arr, int row, int col, int moves) {
       // "edges"
		int rows = arr.length;
        int cols = arr[0].length;

        // Base case: Out of bounds or hit edges
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return -1; // Return -1 to indicate invalid path
        } 

        // Base case: Reached the finish
        if (arr[row][col].equals("F")) {
            return moves;
        }

        // Explore both directions: right and up
        int right = searchMazeMovesHelper(arr, row, col + 1, moves + 1);
        int up = searchMazeMovesHelper(arr, row - 1, col, moves + 1);

        // Return the minimum of the valid paths (non -1)
        if (right == -1) {
            return up; // Only up is valid
        } else if (up == -1) {
            return right; // Only right is valid
        } else {
            return Math.min(right, up); // Return the minimum number of moves
        }
    }

    public static int noOfPaths(String[][] arr) {
        int row = arr.length - 1;
        int col = 0;
        return noOfPathsHelper(arr, row, col);
    }

    public static int noOfPathsHelper(String[][] arr, int row, int col) {
        int rows = arr.length;
        int cols = arr[0].length;

        // Base case: Out of bounds
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 0; // No path here
        }

        // Base case: Reached the finish
        if (arr[row][col].equals("F")) {
            return 1; // Found a valid path
        }

        // Explore both directions: right and up
        int right = noOfPathsHelper(arr, row, col + 1);
        int up = noOfPathsHelper(arr, row - 1, col);

        // Return the total number of paths
        return right + up;
    }
}
