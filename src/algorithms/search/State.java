package algorithms.search;

/**
 * state class implements Comparable
 * @param <T> the type of class we will work with 
 */
public class State<T> implements Comparable<State<T>> {
	
	private State<T> cameFrom;
	private double cost;
	private T value;
	private String key;
	
	/**
	 * CTOR for State
	 * @param value parameter type T
	 */
	public State(T value) {
		this.value=value;
	}
	/**
	 * get of cameFrom
	 * @return the State cameFrom
	 */
	public State<T> getCameFrom() {
		return cameFrom;
	}
	/**
	 * set the cameFrom
	 * @param cameFrom  State<T> parameter to insert in cameFrom
	 */
	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom = cameFrom;
	}
	/**
	 * get of cost
	 * @return the State cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * set the cost
	 * @param cost double parameter to insert in cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * get the value
	 * @return the object
	 */
	public T getValue() {
		return value;
	}
	
	/**
	 * set the value
	 * @param value
	 */
	public void setValue(T value) {
		this.value = value;
	}
	
	/**
	 * get the key
	 * @return key
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * set the key
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
     * Override of Object's equals method
     * check if the object state is equal to this state
     * @param obj State<T> object  
     */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass()) || (this.value == null))
			return false;
		
		State other = (State) obj;
		
		if (other.value == null)
				return false;
		else 
			return this.value.equals(other.value);
	}
	
	/**
     * Override of Comparable compareTo method
     * compare two States
     * @param obj State<T> object 
     */
	@Override
	public int compareTo(State<T> s) {
		return (int)(this.getCost() - s.getCost());	
		// return > 0 if this > s
		//        < 0 if this < s
		//        = 0 if this == s
	}
}
