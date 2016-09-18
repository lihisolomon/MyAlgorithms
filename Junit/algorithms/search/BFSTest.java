package algorithms.search;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public class BFSTest {

	@Test(expected = Exception.class)
	public void testBFS_nullInput_Excpetion() {
		BFS<Position> searcherBFS=new BFS<Position>();
		searcherBFS.search(null);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testBFS_mazeZero_Excpetion(){
		GrowingTreeGenerator m=new GrowingTreeGenerator();
		Maze3d maze=m.generate(0, 2, 2);
		Maze3dSearchable searchableMaze=new Maze3dSearchable(maze);
		BFS<Position> searcherBFS=new BFS<Position>();
		searcherBFS.search(searchableMaze);
	}
	
	@Test(expected = Exception.class)
	public void testBFS_mazeNull_Excpetion(){
		Maze3d maze=null;
		Maze3dSearchable searchableMaze=new Maze3dSearchable(maze);
		BFS<Position> searcherBFS=new BFS<Position>();
		searcherBFS.search(searchableMaze);
	}
	
	@Test
	public void testBFS_BFSreturnSolution(){
		GrowingTreeGenerator m=new GrowingTreeGenerator();
		Maze3d maze=m.generate(3, 3, 3);
		Maze3dSearchable searchableMaze=new Maze3dSearchable(maze);
		BFS<Position> searcherBFS=new BFS<Position>();
		
		assertTrue(searcherBFS.search(searchableMaze)!=null);
	}


}
