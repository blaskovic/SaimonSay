package saimonsay;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import saimonsay.gui.MainGui;
import saimonsay.gui.MenuBar;

public class SaimonSay
{

	public static void createAndShowGUI()
	{
		JFrame frame = new JFrame("Saimon Say");
		Container content = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(50, 50, 640, 480);

		MainGui gui = new MainGui();

		// Menu bar
		MenuBar menuBar = new MenuBar(gui);
		frame.setJMenuBar(menuBar.getMenuBar());

		content.add(gui);

		frame.setVisible(true);
		gui.centerWindow(frame);
	}
	
	public static void main(String[] args)
	{
		try
		{
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
                                	break;
				}
			}
		} catch (Exception e)
		{
		}
		
		// Main loop
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			@Override
            public void run() {
                createAndShowGUI();
            }
        });
	}
}
