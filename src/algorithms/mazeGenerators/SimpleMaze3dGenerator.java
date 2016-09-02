package algorithms.mazeGenerators;

/**
 * SimpleMaze3dGenerator class extends Maze3dGeneratorAbstract
 * @author Lihi Solomon
 *
 */
public class SimpleMaze3dGenerator extends Maze3dGeneratorAbstract {

	/**
	 * generate the maze with my algorithm
	 */
	@Override
	public Maze3d generate(int x, int y,int z) {
		if (x<=0 || y<=0 ||z<=0)
			throw new IndexOutOfBoundsException("value can't be negative or zero.");
		
		//Creates the maze
		Maze3d myMaze= new Maze3d(x,y,z);
		
		// The start Position will be on the outer wall of the first floor
		myMaze.setStartPosition(randomPointInWall(1,y,z));
		// The start Position will be on the outer wall of the last floor
		myMaze.setGoalPosition(randomPointInWall(x,y,z));
	
		createPath(myMaze);
		//myMaze.printMaze();
		randomWall(myMaze);
		
		return myMaze;
	}

	/**
	 * create a random position
	 * @param x is the floor of the maze
	 * @param y is the row of the maze
	 * @param z is the column of the maze
	 * @return a random entry point in the floor
	 */
	public Position randomPointInWall(int x,int y,int z){
		int posY,posZ;
		
		do{
			posY=rand.nextInt(y);
			posZ=rand.nextInt(z);
			}while(!((posY!=0 && posZ==0) || (posY==y-1 && posZ!=0)  || (posY!=0 && posZ==z-1) || (posY==0 && posZ!=0)));
		return (new Position(2*x-1,2*posY+1,2*posZ+1));
	}
	
	/**
	 * create a path to the maze
	 * @param myMaze the maze3d
	 */
	public void createPath(Maze3d myMaze)
	{
		int direction;
		Position currentPosition=new Position(myMaze.getStartPosition());
		Position lastPosition;
		while(!currentPosition.equals(myMaze.getGoalPosition()))
		{
			lastPosition=new Position(currentPosition);
			direction=rand.nextInt(3);
			switch(direction){
				case 0:
					if(currentPosition.getX() > myMaze.getGoalPosition().getX())
						currentPosition.setX(currentPosition.getX()-2);
					else if(currentPosition.getX() < myMaze.getGoalPosition().getX())
						currentPosition.setX(currentPosition.getX()+2);
					break;
				case 1:
					if(currentPosition.getY() > myMaze.getGoalPosition().getY())
						currentPosition.setY(currentPosition.getY()-2);
					else if(currentPosition.getY() < myMaze.getGoalPosition().getY())
						currentPosition.setY(currentPosition.getY()+2);
					break;
				case 2:
					if(currentPosition.getZ() > myMaze.getGoalPosition().getZ())
						currentPosition.setZ(currentPosition.getZ()-2);
					else if(currentPosition.getZ() < myMaze.getGoalPosition().getZ())
						currentPosition.setZ(currentPosition.getZ()+2);
					break;
				default:
					break;
				}
			myMaze.breakerOfWalls(lastPosition, currentPosition);
			
		}
	}
	
	/**
	 * disperse a random wall in the maze
	 * @param maze the maze3d
	 */
	public void randomWall(Maze3d maze)
	{
		Position curr;
		Position last=new Position(1,1,1);
		for(int i=1;i< maze.getMaze().length;i++)
			for(int j=1;j<maze.getMaze()[0].length-1 ;j++)
				for(int k=1;k<maze.getMaze()[0][0].length-1;k++)
				{
					if((i%2!=0 && j%2!=0 && k%2!=0) && maze.getMaze()[i][j][k]!=0)
					{
						curr=new Position(i,j,k);
						maze.setCell(curr, 0);
						if(maze.getCell(curr)==0)
							maze.breakerOfWalls(curr, last);
						last=new Position(curr);
					}
					
				}
	}

}
