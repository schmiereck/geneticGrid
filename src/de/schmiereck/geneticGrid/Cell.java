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

	public byte addStatus(final int statusNo, final byte addStatusValue)
	{
		if (addStatusValue < 0)
		{
			throw new RuntimeException("statusValue < 0");
		}
		final byte statusValue = this.status[statusNo];
		final int newStatusValue = statusValue + addStatusValue;

		final byte usedStatusValue;
		final byte overflowStatusValue;
		
		if (newStatusValue > Byte.MAX_VALUE)
		{
			usedStatusValue = Byte.MAX_VALUE;
			overflowStatusValue = (byte)(newStatusValue - Byte.MAX_VALUE);
		}
		else
		{
			usedStatusValue = (byte)newStatusValue;
			overflowStatusValue = 0;
		}
		
		this.status[statusNo] = usedStatusValue;
		
		return overflowStatusValue;
	}
	
	public byte getStatus(final int statusNo)
	{
		final byte statusValue = this.status[statusNo];
		
		return statusValue;
	}
}
