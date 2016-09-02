package algorithms.search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * DFS generic class extends CommonSearcher<T>
 * @param <T> he type of class we will work with
 */
public class DFS<T> extends CommonSearcher<T> {
	
	private Stack<State<T>> openList;
	private Set<State<T>> closedList;
	
	/**
	 * CTOR
	 */
	public DFS() {
		this.openList=new Stack<State<T>>();
		this.closedList= new HashSet<State<T>>();
	}
	
	/**
	 * Override Searcher method search (implement abstract method from CommonSearcher)
	 * @param s Searchable<T>  type 
	 * @return Solution to the problem 
	 */
	@Override
	public Solution<T> search(Searchable<T> s) {
		openList.push(s.getStartState());
		
		while (!openList.isEmpty()){
			State<T> currState=openList.pop();
			addToEvaluatedNodes();
			if (currState.equals(s.getGoalState())) {
				System.out.println("DFS: number of evaluated Nodes is: "+getNumberOfNodesEvaluated());
				return backTrace(currState);
			}
			if(!checkIfPosionWasVisited(closedList,currState.getValue())){
			//if(!closedList.contains(currState)) {
				addToEvaluatedNodes();
				closedList.add(currState);
				List<State<T>> neighbors = s.getAllPossibleStates(currState);
				for (State<T> neighbor : neighbors) {
					neighbor.setCameFrom(currState);
					neighbor.setCost(s.getMoveCost(currState, neighbor));
					openList.push(neighbor);
				}
			}
		}
		return null;
	}
/* psadu code
1. start to openList
2. while openList not empty
3. pop from openList
4. if start not goal:
	5. start not in closedList
	6. start to closedList
	7. get all neighbors
	8. for eash
		9.update cameFrom and cost
		10.to openList
 */
}
