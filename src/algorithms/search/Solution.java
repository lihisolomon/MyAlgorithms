package algorithms.search;

import java.io.Serializable;
import java.util.Stack;

/**
 * Solution class
 * @param <T> the type of class we will work with 
 */
@SuppressWarnings("serial")
public class Solution<T> implements Serializable{
	private Stack<T> solution;
	
	/**
	 * CTOR
	 */
	public Solution() {
		solution = new Stack<T>();
		solution.clear();
	}
	
	/**
	 * get the solution list
	 * @return stack of solution
	 */
	public Stack<T> getStates() {
		return solution;
	}

	/**
	 * set the solution array
	 * @param solution
	 */
	public void setStates(Stack<T> solution) {
		this.solution = solution;
	}
	
	/**
	 * add s to solution
	 * @param s solution to add to the stack
	 */
	public void addToSolution(T s)
	{
		solution.add(0, s);
	}
	
	@Override
	public String toString()
	{
		String string = "Start:";
		for (T object : solution)
		{
			string +=  object + " -> ";			
		}
		string+="End!";
		return string;
	}
}
