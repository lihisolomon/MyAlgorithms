package algorithms.mazeGenerators;

import java.util.ArrayList;

/**
 * GrowingTreeGenerator Class extends Maze3dGeneratorAbstract
 * @author Lihi Solomon
 *
 */
public class GrowingTreeGenerator extends Maze3dGeneratorAbstract{
	
	protected ArrayList<Position> cellsVisited=new ArrayList<Position>();
	//p is the last that insert to the array
	//GrowingTreeGeneratorRandomCell lastCell=new GrowingTreeGeneratorRandomCell();
	//or
	//p random from the array
	protected GrowingTreeGeneratorLastCell lastCell=new GrowingTreeGeneratorLastCell();

	/**
	 * generate the maze with GrowingTreeGenerator algorithm
	 */
	@Override
	public Maze3d generate(int x, int y,int z) {
		if (x<=0 || y<=0 ||z<=0)
			throw new IndexOutOfBoundsException("value can't be negative or zero.");
		
		Maze3d maze=new Maze3d(x,y,z);
		
		// The start Position will be on the outer wall of the first floor
		maze.setStartPosition(new Position(2*rand.nextInt(x)+1,2*rand.nextInt(y)+1,2*rand.nextInt(z)+1));
		cellsVisited.add(maze.getStartPosition());
		Position p;
		
		while (!cellsVisited.isEmpty()){
			//p is the last that insert to the array
			//or
			//p random from the array
			p=lastCell.chooseNextCell(cellsVisited);
			
			ArrayList<Position> nei=unvisitedNeighbors(p,maze);
			if(nei.isEmpty())
			{
				cellsVisited.remove(p);
			}
			else
			{
				Position randomNei;
				if (nei.size()==1)
					randomNei=nei.get(nei.size()-1);
				else
					randomNei=nei.get(rand.nextInt(nei.size()-1));
				
				cellsVisited.add(randomNei);
				maze.breakerOfWalls(p, randomNei);
				
			}
		}
		chooseGoalPosition(maze);
		return maze;
	}
	
	/**
	 * choose the Goal Position
	 * @param maze the Maze3d
	 */
	public void chooseGoalPosition(Maze3d maze)
	{
		int x=(maze.getMaze().length-1)/2;
		int y=(maze.getMaze()[0].length-1)/2;
		int z=(maze.getMaze()[0][0].length-1)/2;
		Position end;
		do	
		{
			end=new Position(2*rand.nextInt(x)+1,2*rand.nextInt(y)+1,2*rand.nextInt(z)+1);
		}
		while (end.equals(maze.getStartPosition()) || maze.getCell(end)==1);
		
		maze.setGoalPosition(end);
	}
		
	/**
	 * check the unvisited Neighbors
	 * @param p the Position that check his unvisited neighbors
	 * @param maze the Maze3d
	 * @return an array of the unvisited Neighbors
	 */
	public ArrayList<Position> unvisitedNeighbors(Position p,Maze3d maze)
	{
		ArrayList<Position> neighbors=new ArrayList<Position>();
		int x=p.getX();
		int y=p.getY();
		int z=p.getZ();
		if(x < maze.getMaze().length-2 && maze.getMaze()[x+2][y][z]==1)//up
			neighbors.add(new Position(x+2,p.getY(),z));
		else if(x > 2 && maze.getMaze()[x-2][p.getY()][z]==1)
			neighbors.add(new Position(x-2,p.getY(),z));//down
		
		if(y < maze.getMaze()[0].length-2 && maze.getMaze()[x][y+2][z]==1)//forward
			neighbors.add(new Position(x,y+2,z));
		else if(y > 2 && maze.getMaze()[x][y-2][z]==1)//back
			neighbors.add(new Position(x,y-2,z));
		
		if(z < maze.getMaze()[0][0].length-2 && maze.getMaze()[x][y][z+2]==1)//right
			neighbors.add(new Position(x,y,z+2));
		
		else if(z > 2 && maze.getMaze()[x][y][z-2]==1)//left
			neighbors.add(new Position(x,y,z-2));
		
		return neighbors;
	}
	
}
