package algorithms.mazeGenerators;

import java.util.ArrayList;

/**
 * ChooseCellClass abstract class implements ChooseCellInterface
 * @author Lihi Solomon
 */
public abstract class ChooseCellClass implements ChooseCellInterface {

	/**
	 * choose the next cell 
	 */
	@Override
	public abstract Position chooseNextCell(ArrayList<Position> cellsVisited);

	
	
}
