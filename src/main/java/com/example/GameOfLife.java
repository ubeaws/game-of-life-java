package com.example;

public class GameOfLife {

    // Main method that gets called when you run the application
    public static void main(String[] args) {
        // This is where you can initialize your game logic
        System.out.println("Hello, Game of Life!");

        // Example: You can start the game logic here
        runGame();
    }

    // Example method to start your game
    public static void runGame() {
        // Game logic goes here
        System.out.println("Running Game of Life...");
    }

    /**
     * Determines if a cell at position (row, col) will be alive in the next generation.
     *
     * @param board  2D array representing the current state of the board
     * @param row    The row of the cell in question
     * @param col    The column of the cell in question
     * @return       true if the cell will be alive in the next generation, false otherwise
     */
    public boolean isCellAliveNextGen(boolean[][] board, int row, int col) {
        int liveNeighbors = countLiveNeighbors(board, row, col);

        // Apply the rules of the Game of Life
        if (board[row][col]) {
            // Rule 1: Any live cell with fewer than two live neighbors dies.
            // Rule 2: Any live cell with two or three live neighbors lives on to the next generation.
            return liveNeighbors == 2 || liveNeighbors == 3;
        } else {
            // Rule 3: Any dead cell with exactly three live neighbors becomes a live cell.
            return liveNeighbors == 3;
        }
    }

    /**
     * Counts the number of live neighbors around a cell.
     *
     * @param board  2D array representing the current state of the board
     * @param row    The row of the cell in question
     * @param col    The column of the cell in question
     * @return       The number of live neighbors
     */
    private int countLiveNeighbors(boolean[][] board, int row, int col) {
        int liveNeighbors = 0;
        int[] directions = {-1, 0, 1};

        // Check the 8 possible neighbors around the cell
        for (int i = 0; i < directions.length; i++) {
            for (int j = 0; j < directions.length; j++) {
                if (i == 0 && j == 0) continue; // Skip the cell itself
                int newRow = row + directions[i];
                int newCol = col + directions[j];

                // Ensure the neighbor is within bounds and is alive
                if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                    if (board[newRow][newCol]) {
                        liveNeighbors++;
                    }
                }
            }
        }

        return liveNeighbors;
    }
}

