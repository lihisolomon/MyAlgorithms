package algorithms.mazeGenerators;

import java.util.ArrayList;

/**
 * GrowingTreeGeneratorRandomCell class extends ChooseCellClass
 * @author Lihi Solomon
 *
 */
public class GrowingTreeGeneratorRandomCell extends ChooseCellClass {
	protected Position p;
	
	/**
	 * choose the next cell
	 */
	@Override
	public Position chooseNextCell(ArrayList<Position> cellsVisited) {
		return cellsVisited.get(cellsVisited.size()-1);
	}
}
