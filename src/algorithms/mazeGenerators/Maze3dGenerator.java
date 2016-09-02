package algorithms.mazeGenerators;
/**
 * Maze3dGenerator interface
 * @author Lihi Solomon
 */
public interface Maze3dGenerator {
	
	/**
	 * generate a maze
	 * @param x is the floor of the maze
	 * @param y is the row of the maze
	 * @param z is the column of the maze
	 * @return the maze generated
	 */
	public Maze3d generate(int x, int y,int z); 

	/**
	 * get the time it takes to do the algorithm 
	 * @param x is the floor of the maze
	 * @param y is the row of the maze
	 * @param z is the column of the maze
	 * @return time it takes to do the algorithm 
	 */
	public String measureAlgorithmTime(int x, int y,int z); 
}
