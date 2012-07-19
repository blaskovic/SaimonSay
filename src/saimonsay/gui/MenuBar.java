package saimonsay.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import saimonsay.HostGame;

public class MenuBar implements ActionListener
{

	private MainGui mainGui;
	private JMenuItem hostGame;
	private JMenuItem joinGame;

	public MenuBar(MainGui mainGui)
	{
		this.mainGui = mainGui;
	}

	public JMenuBar getMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();

		// File
		JMenu file = new JMenu("File");
		
		this.hostGame = new JMenuItem("Host game");
		this.joinGame = new JMenuItem("Join game");
		file.add(this.hostGame);
		file.add(this.joinGame);
		
		menuBar.add(file);

		// Action listener
		this.hostGame.addActionListener(this);
		this.joinGame.addActionListener(this);

		return menuBar;
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == this.hostGame)
		{
			HostGame hostGame = new HostGame(this.mainGui);
			hostGame.showWindow();
		}
		if(ae.getSource() == this.joinGame)
		{
			System.out.println("join");
		}
	}
}
