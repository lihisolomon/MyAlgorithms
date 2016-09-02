package algorithms.mazeGenerators;

import java.util.Random;

/**
 * Maze3dGeneratorAbstract abstract class implements Maze3dGenerator
 * @author Lihi Solomon
 */
public abstract class Maze3dGeneratorAbstract implements Maze3dGenerator {

	protected Random rand = new Random();
	
	/**
	 * generate the maze
	 */
	@Override
	public abstract Maze3d generate(int x, int y,int z);
	
	/**
	 * get the time it takes to do the algorithm 
	 */
	@Override
	public String measureAlgorithmTime(int x, int y,int z){
		long currenTime=System.currentTimeMillis();
		this.generate(x,y,z);
		long afterGenerate=System.currentTimeMillis();
		return (Long.toString(afterGenerate -currenTime) + " milliseconds");
		
	}

}
