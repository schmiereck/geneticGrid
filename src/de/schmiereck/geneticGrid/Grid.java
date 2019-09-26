/*
 * Copyright (c) open4business GmbH, 2019
 */
package de.schmiereck.geneticGrid;

import java.util.function.Function;

/**
 * <p>
 *	Grid of {@link GridCell}s.
 * </p>
 * 
 * @author smk
 * @version <p>26.09.2019:	created, smk</p>
 */
public class Grid
{
	private final int sizeX;
	private final int sizeY;
	private final GridCell[][] grid;

	public Grid(final int sizeX, final int sizeY)
	{
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		
		this.grid = new GridCell[this.sizeY][this.sizeX];
		
		for (int posY = 0; posY < this.sizeY; posY++)
		{
			for (int posX = 0; posX < this.sizeX; posX++)
			{
				final GridCell gridCell = new GridCell();
				
				this.grid[posY][posX] = gridCell;
			}
		}
	}

	public void forEachTopCell(final Function<GridCell, Void> func)
	{
		for (int posX = 0; posX < this.sizeX; posX++)
		{
			for (int posY = this.sizeY - 1; posY >= 0; posY--)
			{
				final GridCell gridCell = this.grid[posY][posX];
				final Cell cell = gridCell.getCell();
				
				if (cell != null)
				{
					func.apply(gridCell);
					break;
				}
			}
		}
	}
	
	public void forEach(final Function<GridCell, Void> func)
	{
		for (int posY = 0; posY < this.sizeY; posY++)
		{
			for (int posX = 0; posX < this.sizeX; posX++)
			{
				final GridCell gridCell = this.grid[posY][posX];

				func.apply(gridCell);
			}
		}
	}

	public void set(final int posX, final int posY, final Cell cell)
	{
		final GridCell gridCell = this.grid[posY][posX];
		
		gridCell.setCell(cell);
		
		cell.setGridCell(gridCell);
	}
	
	public GridCell getGridCell(final int posX, final int posY)
	{
		final int x = renorm(posX, this.sizeX);
		final int y = renorm(posY, this.sizeY);
		
		final GridCell gridCell = this.grid[y][x];
		
		return gridCell;
	}

	private static int renorm(int pos, int size)
	{
		final int ret;
		
		if (pos < 0)
		{
			ret = size + pos;
		}
		else
		{
			if (pos >= size)
			{
				ret = pos % size;
			}
			else
			{
				ret = pos;
			}
		}
		return ret;
	}

}
