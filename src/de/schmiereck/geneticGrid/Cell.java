/*
 * Copyright (c) open4business GmbH, 2019
 */
package de.schmiereck.geneticGrid;

/**
 * <p>
 *	Cell in Grid.
 * </p>
 * 
 * @author smk
 * @version <p>26.09.2019:	created, smk</p>
 */
public class Cell
{
	private final Genom genom;
	
	private final byte orientation;
	private final byte[] status;
	
	private GridCell gridCell = null;

	public Cell(final Genom genom, 
	            final byte orientation,
	            final byte[] status)
	{
		this.genom = genom;
		this.orientation = orientation;
		this.status = status;
	}
	
	public GridCell getGridCell()
	{
		return this.gridCell;
	}

	public void setGridCell(final GridCell gridCell)
	{
		this.gridCell = gridCell;
	}

	public void addStatus(final int statusNo, final byte statusValue)
	{
		final int value = this.status[statusNo];
		
		if ((value + statusValue) <= Byte.MAX_VALUE)
		{
		}
		this.status[statusNo] += statusValue;
		throw new RuntimeException();
	}
}
