package algorithms.search;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * BFS generic class extends CommonSearcher<T>
 * @param <T> the type of class we will work with
 */
public class BFS<T> extends CommonSearcher<T> {

	private PriorityQueue<State<T>> openList;
	private ArrayList<State<T>> closedList;
	
	public BFS() {
		this.openList=new PriorityQueue<State<T>>();
		this.closedList= new ArrayList<State<T>>();
	}
	/**
	 * Override Searcher method search (implement abstract method from CommonSearcher)
	 * @param s Searchable<T> type 
	 * @return Solution to the problem 
	 */
	@Override
	public Solution<T> search(Searchable<T> s) {
		openList.add(s.getStartState());

		while (!openList.isEmpty()) {
			State<T> currState = openList.poll();
			addToEvaluatedNodes();
			closedList.add(currState);
			
			if (currState.equals(s.getGoalState())) {
				System.out.println("BFS: number of evaluated Nodes is: "+getNumberOfNodesEvaluated());
				return backTrace(currState);
			}
			
			List<State<T>> neighbors = s.getAllPossibleStates(currState);
			
			for (State<T> neighbor : neighbors) {
				if (!openList.contains(neighbor) && !closedList.contains(neighbor)) {
				//if(!openList.contains(neighbor) && !checkIfPosionWasVisited(closedList,neighbor.getValue())){
					neighbor.setCameFrom(currState);
					neighbor.setCost(s.getMoveCost(currState, neighbor));
					openList.add(neighbor);
				}
				else {
					double newPathCost = s.getMoveCost(currState, neighbor);
					if (neighbor.getCost() > newPathCost) {
						neighbor.setCost(newPathCost);
						neighbor.setCameFrom(currState);
						
						if (!openList.contains(neighbor)) {
							openList.add(neighbor);
						} 
						else {
							closedList.remove(neighbor);
						}
					}
				}		
			}
		}
		return null;
	}
}
/*
Advantages of BFS:
1.Breadth first search will never get trapped exploring the useless path forever.
2.If A solution exists the BFS algoritihm will find it.
3.BFS will find the optimal(shorts) path from all avaliable paths.

Advantages of DFS:
1.May find a Solution without examining much of the search space
2.Requires little memory.


Why did we choose to manifest the bfs code as we did?
We wrote it that way so it may be generic and also we used a Pseudo code we got in class.I implemted it the way I though best.


The Mouse and the cheese question
BFS will visit 6 bloks;
DFS will visit 10 blocks;
*/
