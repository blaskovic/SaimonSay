package saimonsay.gui;

import java.awt.Color;
import java.util.Date;
import java.util.Random;
import java.util.Vector;

public class CellColor
{

	public Vector<Color> generateColors(int num)
	{
		Color[] available =
		{
			Color.RED, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN, Color.YELLOW, Color.WHITE, Color.magenta, Color.orange
		};
		Random generator = new Random(new Date().getTime());

		// Unique?
		boolean unique = true;
		if (num > available.length)
		{
			unique = false;
		}

		Vector<Color> colors = new Vector<Color>();

		for (int i = 0; i < num; i++)
		{
			// Get color
			int position = 0;
			Color pickedColor = Color.WHITE;

			while (true)
			{
				position = generator.nextInt(available.length);
				pickedColor = available[position];

				if (!unique)
				{
					break;
				}

				if (!colors.contains(pickedColor))
				{
					break;
				}

			}
			colors.addElement(pickedColor);
		}

		return colors;
	}
}
