package algorithms.demo;

import algorithms.mazeGenerators.*;
import algorithms.search.*;
/**
 * demo class
 */
public class Demo {
	/**
	 * run class the run the search
	 */
	//public static void main(String[] args) {
	public void run(int x,int y,int z){
		//SimpleMaze3dGenerator m=new SimpleMaze3dGenerator();
		GrowingTreeGenerator m=new GrowingTreeGenerator();
		Maze3d maze=m.generate(x,y,z);
		Maze3dSearchable searchableMaze=new Maze3dSearchable(maze);

		System.out.println(maze);
		System.out.println("Start:");
		maze.getStartPosition().printPosition();
		System.out.println("end:");
		maze.getGoalPosition().printPosition();
		
		//---------BFS-----------
		System.out.println("-----------BFS-------------:");
		BFS<Position> searcherBFS=new BFS<Position>();
		Solution<Position> s1=new Solution<Position>();
		s1=searcherBFS.search(searchableMaze);
		System.out.println(s1);
		
		//---------DFS-----------
		System.out.println("-----------DFS-------------:");
		DFS<Position> searcherDFS=new DFS<Position>();
		Solution<Position> s2=new Solution<Position>();
		s2=searcherDFS.search(searchableMaze);
		System.out.println(s2);
		
		System.out.println("finish!!!");
	}

}
