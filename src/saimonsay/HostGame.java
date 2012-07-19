package saimonsay;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;
import network.ServerConnection;
import saimonsay.gui.GameLobby;
import saimonsay.gui.MainGui;

public class HostGame extends GameLobby implements Runnable
{

	protected MainGui mainGui;
	protected JPanel panel;
	protected JFrame frame;
	protected int portNumber;

	public HostGame(MainGui mainGui)
	{
		this.mainGui = mainGui;
	}

	public void showWindow()
	{
		this.frame = new JFrame("Host game");
		final Container content = this.frame.getContentPane();

		this.panel = new JPanel();
		final HostGame thisBackup = this;

		// Port prompt
		final JTextField port = new JTextField("", 5);
		JButton btnPort = new JButton("Host");
		btnPort.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					portNumber = Integer.parseInt(port.getText());
					panel.removeAll();
					panel.invalidate();
					
					new Thread(thisBackup).start();
					panel.add(showRoom());
					
					panel.revalidate();
					frame.repaint();
				} catch (Exception e)
				{
					System.err.println("Bad port");
				}
			}
		});

		this.panel.add(new JLabel("Choose port:"), BorderLayout.NORTH);
		this.panel.add(port, BorderLayout.LINE_START);
		this.panel.add(btnPort, BorderLayout.LINE_END);

		this.frame.add(this.panel);

		this.frame.pack();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainGui.centerWindow(this.frame);
		this.frame.setVisible(true);
	}

	private void startListening(int port)
	{
	}

	@Override
	public void run()
	{
		ServerSocket serverSocket = null;
		try
		{
			serverSocket = new ServerSocket(this.portNumber);
		}
		catch (Exception e)
		{
			System.err.println("Error: startListening():" + e);
		}
		
		// Listen
		while(true)
		{
			try
			{
				Socket socket = serverSocket.accept();
				if(socket != null)
				{
					this.mainGui.connection = new ServerConnection(this.portNumber, socket, serverSocket);
					new Thread(this.mainGui.connection).start();
				}
			}
			catch(Exception e)
			{
				System.err.println("error: startListening():" + e);
			}
		}
	}
}
