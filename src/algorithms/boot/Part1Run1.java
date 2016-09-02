package algorithms.boot;

import algorithms.mazeGenerators.*;

public class Part1Run1 {

	public static void main1(String[] args) {
		
		SimpleMaze3dGenerator m=new SimpleMaze3dGenerator();
		Maze3d maze=m.generate(5, 5, 5);
		System.out.print("the first position: ");
		System.out.println(maze.getStartPosition());
		System.out.print("the goal position: ");
		System.out.println(maze.getGoalPosition());
		System.out.println(maze);
		
		System.out.println(maze.getPossibleMoves(maze.getStartPosition()));
		
		System.out.println(m.measureAlgorithmTime(99, 99, 99));
	}

}
	