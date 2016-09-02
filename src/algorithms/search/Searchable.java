package algorithms.search;

import java.util.List;

/**
 * generic interface Searchable
 * @param <T> the type of we will work with 
 */
public interface Searchable <T> {
	
	/**
	 * get the start state of the problem
	 * @return the start state
	 */
	public State<T> getStartState();

	/**
	 * get the goal state of the problem
	 * @return the goal state
	 */
	public State<T> getGoalState();
	
	/**
	 * get all the possible moves from a State
	 * @param state the state we check
	 * @return ArrayList of states that we can move to from the state we are checking
	 */
	public List<State<T>> getAllPossibleStates(State<T> s);
	
	/**
	 * calc the cost of currState
	 * @param currState
	 * @param neighbor
	 * @return the cost
	 */
	public double getMoveCost(State<T> currState, State<T> neighbor);
}
