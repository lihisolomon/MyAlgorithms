package algorithms.mazeGenerators;

import java.util.ArrayList;

/**
 * ChooseCellInterface interface
 * @author Lihi Solomon
 *
 */
public interface ChooseCellInterface {
	/**
	 * choose the next cell 
	 * @param cellsVisited an array of the visited cell
	 * @return the next position
	 */
	public Position chooseNextCell(ArrayList<Position> cellsVisited);
}
