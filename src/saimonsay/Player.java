package saimonsay;


public class Player {
	
	private int position;
	
	private int gridRows;
	private int gridCols;
	
	public Player(int gridRows, int gridCols)
	{
		this.gridRows = gridRows;
		this.gridCols = gridCols;
		this.position = 0;
	}

	public void setPosition(int position)
	{
		// Out of grid?
		if(position < 0 || position >= (this.gridCols * this.gridRows))
		{
			return;
		}

		// Set position
		this.position = position;
	}

	public void movePlayer(String direction)
	{
		int newPosition = this.position;
		
		if("up".equals(direction))
		{
			newPosition = this.position - this.gridCols;	
		}
		
		if("down".equals(direction))
		{
			newPosition = this.position + this.gridCols;
		}
		
		if("left".equals(direction))
		{
			if((this.position % this.gridCols) != 0)
			{
				newPosition--;
			}
		}

		if("right".equals(direction))
		{
			if(((this.position + 1) % this.gridCols) != 0)
			{
				newPosition++;
			}
		}

		// Out of grid?
		if(newPosition < 0 || newPosition >= (this.gridCols * this.gridRows))
		{
			return;
		}

		this.position = newPosition;
	}

	public int getPosition()
	{
		return this.position;
	}

	public void setPosition(int x, int y)
	{
		// Out of grid?
		if(x < 0 || x >= gridCols || y < 0 || y >= gridRows)
		{
			return;
		}

		this.position = y * this.gridCols + x;
	}
}
