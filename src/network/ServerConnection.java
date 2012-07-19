package network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class which is working as thread on server.
 * @author Pavlina Bartikova, Branislav Blaskovic
 */
public class ServerConnection extends ConnectionMain implements Runnable
{
	private boolean userLogged;
	private String userName;
	
	/**
	 * Set connection details.
	 * @param port
	 * @param socket
	 * @param serverSocket 
	 */
	public ServerConnection(int port, Socket socket, ServerSocket serverSocket)
	{
		// Default
		this.userLogged = false;
		this.userName = "";
		this.port = port;
		this.socket = socket;
		this.serverSocket = serverSocket;
	}

	/**
	 * Create thread and wait in loop for communication commands.
	 */
	@Override
	public void run()
	{
		createSocket();
		
		Object received;
		
		// Main listening loop
		while(true)
		{
			received = getObject();

			if(received == null)
			{
				System.err.println("Error: listen(): null received (shutting down thread)");
				closeConnection();
				return;
			}
		}
	}
	
	/**
	 * Creates socket for connection.
	 */
	private void createSocket()
	{
		try
		{
			// Sockets
			//this.serverSocket = new ServerSocket(this.port);
			//this.socket = this.serverSocket.accept();
			// Output stream
			this.outputStream = this.socket.getOutputStream();
			this.objectOutputStream = new ObjectOutputStream(this.outputStream);
			// Input stream
			this.inputStream = this.socket.getInputStream();
			this.objectInputStream = new ObjectInputStream(this.inputStream);
		}
		catch(Exception e)
		{
			System.err.println("Error: createSocket(): " + e);
		}
	}

	/**
	 * Put user online.
	 * @param username 
	 */
	public void userOnline(String username)
	{
		this.userLogged = true;
		this.userName = username;
	}

	/**
	 * 
	 * @return true if user is logged in
	 */
	public boolean isLogged()
	{
		return this.userLogged;
	}
	
	/**
	 * Safely close connection.
	 */
	public void closeConnection()
	{
		try
		{
			System.err.println("Shutting down");
			this.objectInputStream.close();
			this.inputStream.close();
			this.outputStream.close();
			this.objectOutputStream.close();
			this.socket.close();
		}
		catch (Exception e)
		{
			System.err.println("Error: closeConnection(): " + e);
		}
	}

}
