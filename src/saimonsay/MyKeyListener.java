package saimonsay;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import saimonsay.gui.MainGui;


public class MyKeyListener implements KeyListener{

	private final MainGui mainGui;

	public MyKeyListener(MainGui mainGui)
	{
		this.mainGui = mainGui;	
	}

	@Override
	public void keyTyped(KeyEvent ke)
	{
	}

	@Override
	public void keyPressed(KeyEvent ke)
	{
		// No players
		if(this.mainGui.players == null || this.mainGui.players.size() == 0)
		{
			return;
		}
		
		if (ke.getKeyCode() == KeyEvent.VK_DOWN || ke.getKeyCode() == KeyEvent.VK_S)
		{
			this.mainGui.players.elementAt(0).movePlayer("down");
			this.mainGui.playArea.grid.updateArea();
		}
		
		if (ke.getKeyCode() == KeyEvent.VK_UP || ke.getKeyCode() == KeyEvent.VK_W)
		{
			this.mainGui.players.elementAt(0).movePlayer("up");
			this.mainGui.playArea.grid.updateArea();
		}
		
		if (ke.getKeyCode() == KeyEvent.VK_LEFT || ke.getKeyCode() == KeyEvent.VK_A)
		{
			this.mainGui.players.elementAt(0).movePlayer("left");
			this.mainGui.playArea.grid.updateArea();
		}

		if (ke.getKeyCode() == KeyEvent.VK_RIGHT || ke.getKeyCode() == KeyEvent.VK_D)
		{
			this.mainGui.players.elementAt(0).movePlayer("right");
			this.mainGui.playArea.grid.updateArea();
		}
	}

	@Override
	public void keyReleased(KeyEvent ke)
	{
	}

}
