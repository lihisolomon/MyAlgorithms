package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

/**
 * GrowingTreeGeneratorLastCell class extends ChooseCellClass
 * @author Lihi Solomon
 */
public class GrowingTreeGeneratorLastCell extends ChooseCellClass {
	protected Position p;
	protected Random rand=new Random();

	/**
	 * choose the next cell 
	 */
	@Override
	public Position chooseNextCell(ArrayList<Position> cellsVisited) {
		if(cellsVisited.size()==1)
			return cellsVisited.get(0);
		else
		{
			return cellsVisited.get(rand.nextInt(cellsVisited.size()-1));
		}
			
}
	
}
