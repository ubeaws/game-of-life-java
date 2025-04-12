package com.example;

public class GameOfLife {

    public boolean isCellAliveNextGen(boolean[][] grid, int row, int col) {
        int liveNeighbors = 0;
        int[] directions = {-1, 0, 1};

        for (int dr : directions) {
            for (int dc : directions) {
                if (dr == 0 && dc == 0) continue;
                int r = row + dr, c = col + dc;
                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {
                    if (grid[r][c]) liveNeighbors++;
                }
            }
        }

        if (grid[row][col]) {
            return liveNeighbors == 2 || liveNeighbors == 3;
        } else {
            return liveNeighbors == 3;
        }
    }
}

