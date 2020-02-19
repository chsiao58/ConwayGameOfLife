package com.zipcodeconway;

public class ConwayGameOfLife {
    Integer dimension;
    int[][] matrix;

    public ConwayGameOfLife(Integer dimension) {
        this.dimension = dimension;
        matrix = createRandomStart(dimension);

     }

    public ConwayGameOfLife(Integer dimension, int[][] startmatrix) {
        this.dimension = dimension;
        this.matrix = startmatrix;
    }

    public static void main(String[] args) {
        ConwayGameOfLife sim = new ConwayGameOfLife(50);
        int[][] endingWorld = sim.simulate(50);
    }

    // Contains the logic for the starting scenario.
    // Which cells are alive or dead in generation 0.
    // allocates and returns the starting matrix of size 'dimension'
    private int[][] createRandomStart(Integer dimension) {
        return new int[1][1];
    }

    public int[][] simulate(Integer maxGenerations) {
        return new int[1][1];
    }

    // copy the values of 'next' matrix to 'current' matrix,
    // and then zero out the contents of 'next' matrix
    public void copyAndZeroOut(int [][] next, int[][] current) {
    }

    // Calculate if an individual cell should be alive in the next generation.
    // Based on the game logic:
	/*
		Any live cell with fewer than two live neighbours dies, as if by needs caused by underpopulation.
		Any live cell with more than three live neighbours dies, as if by overcrowding.
		Any live cell with two or three live neighbours lives, unchanged, to the next generation.
		Any dead cell with exactly three live neighbours cells will come to life.
	*/
    private int isAlive(int row, int col, int[][] world) {
        int numOfLiveNeighbor = 0;
        for (int i = row-1; i <= row+1; i++) {
            for(int j = col-1; j <= col+1; j++) {
                if (    !(i == row && j == col) &&
                         (i >= 0 && i < world[0].length) &&
                         (j >= 0 && j < world[0].length)) {
                    if(world[i][j] == 1)
                        numOfLiveNeighbor++;
                }
            }
        }

        if(world[row][col] == 0) {
            if (numOfLiveNeighbor == 3)
                return 1;
            else
                return 0;
        }

        else if(world[row][col] == 1) {
            if (numOfLiveNeighbor == 2 || numOfLiveNeighbor == 3)
                return 1;
            else
                return 0;
        }

        throw new IllegalStateException();
    }
}
