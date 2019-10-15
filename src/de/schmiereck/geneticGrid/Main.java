package de.schmiereck.geneticGrid;

/**
 * <p>
 *	Main.
 * </p>
 * 
 * 
 * 
 * @author smk
 * @version <p>26.09.2019:	created, smk</p>
 */
public class Main
{
	private static final int ENERGIE_STATUS = 0;
	private static final byte SUN_POWER = 3;
	
	public static void main(String[] args)
	{
		final Grid grid = new Grid(4, 4);
		
		final Genom genom = new Genom();
		final byte orientation = 0;
		final byte[] status = new byte[1];
		
		final Cell cell = new Cell(genom, orientation, status);
		
		grid.set(1, 1, cell);
		
		run(grid);
	}

	private static void run(final Grid grid)
	{
		// Sunshine:
		grid.forEachTopCell
		(
		 	(GridCell gridCell) ->
		 	{
		 		final Void ret = null;
		 		
				final Cell cell = gridCell.getCell();
				
				if (cell != null)
				{
					final byte overflowStatusValue = cell.addStatus(ENERGIE_STATUS, SUN_POWER);
					System.out.print("S(" + overflowStatusValue + ")");
				}
				
		 		return ret;
		 	}
		);
		
		// Calculate Rules and new Status:
		grid.forEach
		(
		 	(GridCell gridCell) ->
		 	{
		 		final Void ret = null;
		 		
				final Cell cell = gridCell.getCell();
				
				if (cell != null)
				{
					calcCell(grid, gridCell, cell);
				}
				
		 		return ret;
		 	}
		);
	}

	private static void calcCell(final Grid grid, final GridCell gridCell, final Cell cell)
	{
		final int energieStatusValue = cell.getStatus(ENERGIE_STATUS);
		
		if (energieStatusValue == 0)
		{
			killCell(gridCell);
		}
		else
		{
			new RuntimeException("no rulez");
		}
		System.out.print("C(" + energieStatusValue + ")");
	}

	private static void killCell(final GridCell gridCell)
	{
		gridCell.setCell(null);
	}

}
