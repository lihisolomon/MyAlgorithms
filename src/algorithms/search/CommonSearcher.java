package algorithms.search;

import java.util.Set;

/**
 * CommonSearcher abstract class implements Searcher
 * @param <T> the type of class we will work with
 */
public abstract class CommonSearcher<T> implements Searcher<T> {
	protected int evaluatedNodes;
	
	public CommonSearcher() {
		evaluatedNodes=0;
	}
	 /**
	  * Override Searcher method search (abstract)
	  */
	@Override
	public abstract Solution<T> search(Searchable<T> s);

	/**
     * Override Searcher method getNumberOfNodesEvaluated
     * @return the number of nodes evaluated
     */
	@Override
	public int getNumberOfNodesEvaluated() {
		return evaluatedNodes;
	}
	
	public void addToEvaluatedNodes(){
		evaluatedNodes++;
	}
	
	/**
	 * protected method backTrace
	 * @param goalState State<T> the goal state of the problem
	 * @return Solution<T> the Solution of the problem
	 */
	protected Solution<T> backTrace(State<T> goalState) {
		Solution<T> sol = new Solution<T>();
		State<T> currState = goalState;
		while (currState!=null) {
			sol.addToSolution(currState.getValue());
			currState = currState.getCameFrom();
		}
		return sol;
	}
}
