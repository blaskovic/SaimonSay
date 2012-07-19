package saimonsay.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import javax.swing.JPanel;
import saimonsay.MyKeyListener;
import saimonsay.Player;

public class PlayArea extends JPanel
{
	protected MainGui mainGui;
	public PlayGrid grid;

	public PlayArea(MainGui mainGui)
	{
		this.mainGui = mainGui;


		int height = 3;
		int width = 3;

		// Temporary test data
		Player user = new Player(height, width);
		Vector<Player> players = new Vector<Player>();
		players.addElement(user);
		players.addElement(user);

		this.mainGui.players = players;

		// Playing grid generator
		CellColor cellColor = new CellColor();
		this.grid = new PlayGrid(players, width, height);

		// Key listeners
		setFocusable(true);
		addKeyListener(new MyKeyListener(this.mainGui));

		add(this.grid);
		this.grid.setColors(cellColor.generateColors(width * height));
		this.grid.updateArea();
	}
}
