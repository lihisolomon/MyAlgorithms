package algorithms.boot;

import algorithms.mazeGenerators.*;
import algorithms.search.*;

public class Part2Run1 {
	public static void main(String[] args) {		
		//SimpleMaze3dGenerator m=new SimpleMaze3dGenerator();
		GrowingTreeGenerator m=new GrowingTreeGenerator();
		Maze3d maze=m.generate(1, 3, 3);
		Maze3dSearchable searchableMaze=new Maze3dSearchable(maze);

		System.out.println(maze);
		System.out.println("Start:");
		maze.getStartPosition().printPosition();
		System.out.println("end:");
		maze.getGoalPosition().printPosition();
		
		BFS<Position> searcherBFS=new BFS<Position>();
		Solution<Position> s=new Solution<Position>();
		s=searcherBFS.search(searchableMaze);
		System.out.println(s);
		System.out.println("finish");
	}

}
