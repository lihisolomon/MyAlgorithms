package algorithms.boot;

import algorithms.mazeGenerators.*;

public class Part1Run2 {

	private static void testMazeGenerator(Maze3dGenerator mg){
		// prints the time it takes the algorithm to run
		System.out.println(mg.measureAlgorithmTime(99,99,99));
		// generate another 3d maze
		Maze3d maze=mg.generate(3,3,3);
		// get the maze entrance
		Position p=maze.getStartPosition();
		// print the position
		System.out.println("start"+p); // format "{x,y,z}"
	
		// get all the possible moves from a position
		String[] moves=maze.getPossibleMoves(p);
		// print the moves
				for(String move : moves)
			System.out.println(move);
				
		// prints the maze exit position
		System.out.println(maze.getGoalPosition());
		try{
			// get 2d cross sections of the 3d maze
			int[][] maze2dx=maze.getCrossSectionByX(2);
			// TODO add code to print the array
			print2dAraay(maze2dx);
			int[][] maze2dy=maze.getCrossSectionByY(5);
			// TODO add code to print the array
			print2dAraay(maze2dy);
			int[][] maze2dz=maze.getCrossSectionByZ(0);
			// TODO add code to print the array
			print2dAraay(maze2dz);
			// this should throw an exception!
			maze.getCrossSectionByX(-1);
		} catch (IndexOutOfBoundsException e){
			System.out.println("good!");
		}
		
	}
	public static void print2dAraay(int[][] maze2d)
	{
		System.out.println("{");
		for (int i=0;i<maze2d.length;i++)
		{
			for (int j=0;j<maze2d[0].length;j++)
			{
				System.out.print(maze2d[i][j]+ ",");
			}System.out.println("");
		}System.out.println("}");
	}
	public static void main(String[] args) {
		testMazeGenerator(new SimpleMaze3dGenerator());
		testMazeGenerator(new GrowingTreeGenerator());
	}

}
