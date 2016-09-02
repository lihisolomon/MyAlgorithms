package algorithms.mazeGenerators;

/**
 * Position class
 * @author Lihi Solomon
 */
public class Position {
	private int x;
	private int y;
	private int z;
	
	/**
	 * CTOR
	 * @param x is the floor of the maze
	 * @param y is the row of the maze
	 * @param z is the column of the maze
	 */
	public Position(int x,int y, int z) {
		this.x=x; //floor
		this.y=y; //row
		this.z=z; //column 
	}
	
	/**
	 * copy CTOR  
	 * @param pos Position to copy
	 */
	public Position(Position pos) {
		this.x=pos.getX(); //floor
		this.y=pos.getY(); //row
		this.z=pos.getZ(); //column 
	}

	/**
	 * get the x
	 * @return x value- floor
	 */
	public int getX() {
		return x;
	}

	/**
	 * set the x 
	 * @param x value
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * get the y
	 * @return y value- row
	 */
	public int getY() {
		return y;
	}

	/**
	 * set the y
	 * @param y value- row
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * get the z
	 * @return z value- column
	 */
	public int getZ() {
		return z;
	}

	/**
	 * set the z
	 * @param z value- column
	 */
	public void setZ(int z) {
		this.z = z;
	}
	
	/**
	 * Override object method equals
	 * @param obj the object we will check if equal
	 * @return true if equal and false if not
	 */
	@Override
	public boolean equals(Object pos)
	{
		Position p=(Position) pos;
		if(this.x==p.getX() && this.y==p.getY() && this.z==p.getZ())
			return true;
		return false;
	}
	
	/**
	 * Override object method toString
	 * change the default to string method of object
	 * @return the string we will get for Position
	 */
	public String toString()
	{
		return "{"+this.x+","+this.y+","+this.z+"}";
	}
	
	/**
	 * print position
	 */
	public void printPosition()
	{
		System.out.println("{"+this.x+","+this.y+","+this.z+"}");
	}
}
