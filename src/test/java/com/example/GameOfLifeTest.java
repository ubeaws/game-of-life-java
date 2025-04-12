package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameOfLifeTest {

    @Test
    public void testCellLivesWithTwoOrThreeNeighbors() {
        GameOfLife game = new GameOfLife();
        boolean[][] grid = {
            {false, true,  false},
            {true,  true,  false},
            {false, false, false}
        };

        assertTrue(game.isCellAliveNextGen(grid, 1, 1)); // Should survive
    }

    @Test
    public void testDeadCellComesToLifeWithThreeNeighbors() {
        GameOfLife game = new GameOfLife();
        boolean[][] grid = {
            {false, true,  false},
            {true,  false, true},
            {false, false, false}
        };

        assertTrue(game.isCellAliveNextGen(grid, 1, 1)); // Should come to life
    }
}

