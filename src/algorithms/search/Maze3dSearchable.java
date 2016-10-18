package algorithms.search;

import java.util.ArrayList;
import java.util.List;

import algorithms.mazeGenerators.*;
/**
 * Maze3dSearchable class implements Searchable
 */
public class Maze3dSearchable implements Searchable<Position> {
	private Maze3d maze;
	
	/**
	 * CTOR
	 * @param maze Maze3d maze
	 */
	public Maze3dSearchable(Maze3d maze) {
		this.maze=maze;
	}
	
	/**
	 * Override of Searchable method getStartState
	 * @return State- the start position 
	 */
	@Override
	public State<Position> getStartState() {
		return new State<Position>(maze.getStartPosition());
	}

	/**
	 * Override of Searchable method getGoalState
	 * @return State the goal position 
	 */
	@Override
	public State<Position> getGoalState() {
		return new State<Position>(maze.getGoalPosition());
	}

	/**
	 * Override of Searchable method getAllPossibleStates
	 * @return ArrayList of all the possible moves 
	 */
	@Override
	public List<State<Position>> getAllPossibleStates(State<Position> s) {
		Position currP=s.getValue();
		String[] moves=maze.getPossibleMoves(currP);
		List<State<Position>> possibleStates=new ArrayList<State<Position>>();
		for (String moveToState: moves)
		{
			if (moveToState.equals("UP"))
			{
				possibleStates.add(new State<Position>(new Position(currP.getX()+2,currP.getY(),currP.getZ())));
			}
			else if (moveToState.equals("DOWN"))
			{
				possibleStates.add(new State<Position>(new Position(currP.getX()-2,currP.getY(),currP.getZ())));
			}
			else if (moveToState.equals("FORWARD"))
			{
				possibleStates.add(new State<Position>(new Position(currP.getX(),currP.getY()+2,currP.getZ())));
			}
			else if (moveToState.equals("BACK"))
			{
				possibleStates.add(new State<Position>(new Position(currP.getX(),currP.getY()-2,currP.getZ())));
			}
			else if (moveToState.equals("RIGHT"))
			{
				possibleStates.add(new State<Position>(new Position(currP.getX(),currP.getY(),currP.getZ()+2)));
			}
			else if (moveToState.equals("LEFT"))
			{
				possibleStates.add(new State<Position>(new Position(currP.getX(),currP.getY(),currP.getZ()-2)));
			}
			
		}
		return possibleStates;
	}

	/**
	 * calc the cost of currState
	 */
	@Override
	public double getMoveCost(State<Position> currState, State<Position> neighbor) {
		return currState.getCost()+1;
	}

	

}
