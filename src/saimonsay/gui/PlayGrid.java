package saimonsay.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;
import javax.swing.JPanel;
import saimonsay.Player;

public class PlayGrid extends JPanel
{

	// Cell info	
	protected int cellWidth = 30;
	protected int cellHeight = 30;
	protected int margin = 5;
	// Grid info
	protected int count;
	protected int rows;
	protected int cols;
	private Vector<Color> backgroundColors;
	// Players
	protected Vector<Player> players;

	public PlayGrid(Vector<Player> players, int rows, int cols)
	{
		this.count = players.size();
		this.players = players;
		this.rows = rows;
		this.cols = cols;
	}

	

	/**
	 * Paint grid for playing arenas
	 *
	 * @param g1
	 */
	@Override
	public void paintComponent(Graphics g1)
	{
		super.paintComponent(g1);
		Graphics2D g = (Graphics2D) g1;

		// Border
		for (int i = 0; i < this.count; i++)
		{
			int x = (this.cellWidth * this.cols + this.margin) * i + this.margin;
			int y = 0;
			g1.drawRect(x, y, this.cellWidth * this.cols, this.cellHeight * this.rows);

			// Cells
			int order = 0;
			for(int cellRows = 0; cellRows < this.rows; cellRows++)
			{
				for(int cellCols = 0; cellCols < this.cols; cellCols++)
				{
					int startX = x + cellCols * cellWidth;
					int startY = y + cellRows * cellHeight;
					// Border
					g1.setColor(backgroundColors.elementAt(order));
					g1.fillRect(startX, startY, this.cellWidth, this.cellHeight);
					// Background
					g1.setColor(Color.BLACK);
					g1.drawRect(startX, startY, this.cellWidth, this.cellHeight);
					paintPlayerPosition(g1, players.elementAt(i), order, startX, startY);
					order++;
				}
			}
		}
	}

	private void paintPlayerPosition(Graphics g1, Player player, int position, int startX, int startY)
	{
		if(position == player.getPosition())
		{
			g1.setColor(Color.WHITE);
			g1.fillOval(startX + this.cellWidth/4, startY + this.cellHeight/4, this.cellWidth / 2, this.cellHeight / 2);
			g1.setColor(Color.BLACK);
			g1.drawOval(startX + this.cellWidth/4, startY + this.cellHeight/4, this.cellWidth / 2, this.cellHeight / 2);
		}
	}

	public void updateArea()
	{
		setPreferredSize(new Dimension(640, 300));
		repaint();
		validate();
	}

	void setColors(Vector<Color> colors)
	{
		this.backgroundColors = colors;
	}
}
