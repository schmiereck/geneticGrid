/*
 * Copyright (c) schmiereck, 2019
 */
package de.schmiereck.geneticGrid;

/**
 * <p>
 *	Main.
 * </p>
 * 
 * @author smk
 * @version <p>26.09.2019:	created, smk</p>
 */
public class Main
{
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
					System.out.print("S");
					cell.addStatus(0, SUN_POWER);
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
					System.out.print("X");
				}
				
		 		return ret;
		 	}
		);
	}

}
