package algorithms.boot;

import algorithms.mazeGenerators.*;
import algorithms.search.*;

public class Part2Run2 {

	public static void main(String[] args) {
		//SimpleMaze3dGenerator m=new SimpleMaze3dGenerator();
		GrowingTreeGenerator m=new GrowingTreeGenerator();
		Maze3d maze=m.generate(30,30,30);
		Maze3dSearchable searchableMaze=new Maze3dSearchable(maze);
		
		System.out.println(maze);
		System.out.println("Start:");
		maze.getStartPosition().printPosition();
		System.out.println("end:");
		maze.getGoalPosition().printPosition();
		
		DFS<Position> searcherDFS=new DFS<Position>();
		Solution<Position> s=new Solution<Position>();
		s=searcherDFS.search(searchableMaze);
		System.out.println(s);
		
		System.out.println("finish");
	}

}
