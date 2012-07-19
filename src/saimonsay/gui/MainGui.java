package saimonsay.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import network.ServerConnection;
import saimonsay.Player;

public class MainGui extends JPanel
{

	public PlayArea playArea;
	public Vector<Player> players;
	public ServerConnection connection;

	public MainGui()
	{

		JPanel arena = new JPanel();
		this.playArea = new PlayArea(this);

		arena.add(this.playArea);

		add(new JLabel("asd"), BorderLayout.NORTH);
		add(arena, BorderLayout.CENTER);

	}
	
	public void centerWindow(JFrame frame)
	{
		// Center window
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		
		// Move the window
		frame.setLocation(x, y);
	}
}
