package algorithms.mazeGenerators;

import java.util.ArrayList;

/**
 * Maze3D Clsss with array, startPosition and EndPosition
 * @author Lihi Solomon
 */
public class Maze3d {
	protected int[][][] maze;
	protected Position start;
	protected Position end;
	
	/**
	 * Constructor
	 * @param x is the floor of the maze
	 * @param y is the row of the maze
	 * @param z is the column of the maze
	 */
	public Maze3d(int x, int y, int z) {
		maze=new int [2*x+1][2*y+1][2*z+1];
		
		for (int i=0; i<maze.length; i++)
		{
			for (int k=0; k<maze[0].length; k++)
			{
				for (int j=0; j<maze[0][0].length; j++)
				{
					maze[i][k][j]=1;
				}
			}
		}
	}

	/**
	 * get the maze
	 * @return int[][][] maze
	 */
	public int[][][] getMaze() {
		return maze;
	}

	/**
	 * set the maze
	 * @param maze
	 */
	public void setMaze(int[][][] maze) {
		this.maze = maze;
	}

	/**
	 * get the start Position of the maze
	 * @return Position start
	 */
	public Position getStartPosition() {
		return start;
	}

	/**
	 * set the start Position of the maze
	 * @param start
	 */
	public void setStartPosition(Position start) {
		maze[start.getX()][start.getY()][start.getZ()]=0;
		this.start = start;
	}

	/**
	 * get the start Position of the maze
	 * @return Position end
	 */
	public Position getGoalPosition() {
		return end;
	}

	/**
	 * set the start Position of the maze
	 * @param end
	 */
	public void setGoalPosition(Position end) {
		maze[end.getX()][end.getY()][end.getZ()]=0;
		this.end = end;
	}
	
	/**
	 * maze to string
	 */
	public String toString()
	{
		StringBuilder output = new StringBuilder();
		
		for (int i=0;i<maze.length;i++)
		{
			for (int k=0;k<maze[0].length;k++)
			{
				for (int j=0;j<maze[0][0].length;j++)
					output.append(maze[i][k][j]+" ");
				output.append("\n");
			}
			output.append("\n");
		}
		return output.toString();
	}
	
	/**
	 * get the maze by section x
	 * @param x the index of x axis we want to get 2D maze by
	 * @return int[][] 2D maze in the x we selected
	 * @throws IndexOutOfBoundsException if x is out of the maze range
	 */
	public int[][] getCrossSectionByX(int x) throws IndexOutOfBoundsException {
		if (x<0 || x>=maze.length)
		{
			throw new IndexOutOfBoundsException();
		}
		int[][] maze2d= new int[maze[0].length][maze[0][0].length];
		for(int j=0; j<maze[0].length; j++)
		{
			for(int k=0; k<maze[0][0].length; k++)
				maze2d[j][k] = maze[x][j][k];
		}
		return maze2d;
	}
	
	/**
	 * get the maze by section y
	 * @param y the index of y axis we want to get 2D maze by
	 * @return int[][] 2D maze in the y we selected
	 * @throws IndexOutOfBoundsException if y is out of the maze range
	 */
	public int[][] getCrossSectionByY(int y) throws IndexOutOfBoundsException {
		if (y<0 || y>=maze[0].length)
		{
			throw new IndexOutOfBoundsException();
		}
		int[][] maze2d = new int[maze.length][maze[0][0].length];
		for(int i=0; i<maze.length; i++)
		{
			for(int k=0; k<maze[0][0].length; k++)
				maze2d[i][k] = maze[i][y][k];
		}
		return maze2d;
	}
	
	/**
	 * get the maze by section z
	 * @param z the index of z axis we want to get 2D maze by
	 * @return int[][] 2D maze in the z we selected
	 * @throws IndexOutOfBoundsException if z is out of the maze range
	 */
	public int[][] getCrossSectionByZ(int z) throws IndexOutOfBoundsException {
		if (z<0 || z>=maze[0][0].length)
		{
			throw new IndexOutOfBoundsException();
		}
		int[][] maze2d = new int[maze.length][maze[0].length];
		for(int i=0; i<maze.length; i++)
		{
			for(int j=0; j<maze[0].length; j++)
				maze2d[i][j] = maze[i][j][z];
		}
		return maze2d;
	}
	
	/**
	 * set the position pos to a var number
	 * @param pos Position to set
	 * @param var number to set the number
	 */
	public void setCell(Position pos,int var)
	{
		this.maze[pos.getX()][pos.getY()][pos.getZ()]=var;
	}
	
	/**
	 * get the value of the position
	 * @param pos the position we want the value
	 * @return the value of the position
	 */
	public int getCell(Position pos)
	{
		return maze[pos.getX()][pos.getY()][pos.getZ()];
	}
	
	/**
	 * get possible moves from a position
	 * @param p the position to check
	 * @return String[] of the possible moves
	 */
	public String[] getPossibleMoves(Position pos)
	{
		ArrayList<String> direction=new ArrayList<String>();
		
		int pX = pos.getX();
		int pY = pos.getY();
		int pZ = pos.getZ();
		
		if(pX+2<maze.length && this.maze[pX+2][pY][pZ]==0 && this.maze[pX+1][pY][pZ]==0)
			direction.add("UP");
		if(pX-2>-1 && this.maze[pX-2][pY][pZ]==0 && this.maze[pX-1][pY][pZ]==0)
			direction.add("DOWN");
		if(pY+2<maze[0].length && this.maze[pX][pY+2][pZ]==0 && this.maze[pX][pY+1][pZ]==0)
			direction.add("FORWARD");
		if(pY-2>-1 && this.maze[pX][pY-2][pZ]==0 && this.maze[pX][pY-1][pZ]==0)
			direction.add("BACK");
		if(pZ+2<maze[0][0].length && this.maze[pX][pY][pZ+2]==0 && this.maze[pX][pY][pZ+1]==0)
			direction.add("RIGHT");
		else if(pZ-2>-1 && this.maze[pX][pY][pZ-2]==0 && this.maze[pX][pY][pZ-1]==0)
			direction.add("LEFT");
		
		return direction.toArray(new String[direction.size()]);
	}
	
	/**
	 * set 0 from currentP to targetP
	 * @param currentP from position
	 * @param targetP to position
	 */
	public void breakerOfWalls(Position currentP,Position targetP)
	{
		int cX=currentP.getX();
		int cY=currentP.getY();
		int cZ=currentP.getZ();
		int tX=targetP.getX();
		int tY=targetP.getY();
		int tZ=targetP.getZ();
		this.setCell(new Position((cX+tX)/2, (cY+tY)/2, (cZ+tZ)/2), 0);
		this.setCell(targetP, 0);
	}
	
}
