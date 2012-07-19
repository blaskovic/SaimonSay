package saimonsay.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameLobby {

	protected JPanel showRoom()
	{
		JPanel roomPanel = new JPanel();
		roomPanel.add(new JLabel("room"));

		return roomPanel;
	}

}
