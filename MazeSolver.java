import java.util.Scanner;

public class MazeSolver {
    public static void main(String[] args) {
        // Define the maze using a 2D array
        char[][] maze = {
                {'S', ' ', '#', '#', '#', ' '},
                {'#', ' ', '#', ' ', '#', ' '},
                {'#', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '', '#'},
                {'#', ' ', ' ', ' ', ' ', 'E'}
        };

        // Display the initial maze
        printMaze(maze);

        // Find the starting position
        int[] start = findStart(maze);

        // Solve the maze
        if (start != null && solveMaze(maze, start[0], start[1])) {
            System.out.println("Maze solved!");
        } else {
            System.out.println("No solution found.");
        }
    }

    // Method to print the current state of the maze
    private static void printMaze(char[][] maze) {
        for (char[] row : maze) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Method to find the starting position in the maze
    private static int[] findStart(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Recursive method to solve the maze
    private static boolean solveMaze(char[][] maze, int row, int col) {
        // Check if the current position is outside the maze or a wall
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || maze[row][col] == '#' || maze[row][col] == 'V') {
            return false;
        }

        // Check if the current position is the exit
        if (maze[row][col] == 'E') {
            return true;
        }

        // Mark the current position as visited
        maze[row][col] = 'V';

        // Recursively try moving in all directions
        if (solveMaze(maze, row + 1, col) || solveMaze(maze, row - 1, col) ||
                solveMaze(maze, row, col + 1) || solveMaze(maze, row, col - 1)) {
            return true;
        }

        // If none of the directions lead to the exit, backtrack
        maze[row][col] = ' ';
        return false;
    }
}
