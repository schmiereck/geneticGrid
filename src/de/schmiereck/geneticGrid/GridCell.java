package de.schmiereck.geneticGrid;

/**
 * <p>
 *	Grid-Cell of a {@link Grid}.
 * </p>
 * 
 * @author smk
 * @version <p>26.09.2019:	created, smk</p>
 */
public class GridCell
{
	private final GridCell[] next = new GridCell[4];
	
	private Cell cell = null;

	public Cell getCell()
	{
		return this.cell;
	}

	public void setCell(Cell cell)
	{
		this.cell = cell;
	}
	
	public GridCell getNextGridCell(final int orientation)
	{
		return this.next[orientation];
	}
	
	public void setNextGridCell(final int orientation, final GridCell gridCell)
	{
		this.next[orientation] = gridCell;
	}

}
