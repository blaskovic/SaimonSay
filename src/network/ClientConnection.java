package network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Class for network connection on client's side.
 * @author Pavlina Bartikova, Branislav Blaskovic
 */
public class ClientConnection extends ConnectionMain
{

	public ClientConnection()
	{
		this.connected = false;
		this.address = "";
	}
	
	/**
	 * Set server details for connection.
	 * @param address
	 * @param port 
	 */
	public void setServerDetails(String address, int port)
	{
		this.address = address;
		this.port = port;
	}
	
	/**
	 * Try to connect to server via provided settings.
	 */
	public void connectToServer()
	{
		try
		{
			this.socket = new Socket(this.address, this.port);
			// Output stream
			this.outputStream = this.socket.getOutputStream();
			this.objectOutputStream = new ObjectOutputStream(this.outputStream);
			// Input stream
			this.inputStream = this.socket.getInputStream();
			this.objectInputStream = new ObjectInputStream(this.inputStream);
			this.connected = true;
		}
		catch (Exception e)
		{
			System.err.println("Error: connectToServer(): " + e);
			this.connected = false;
		}
	}
	
	public boolean isConnected()
	{
		return this.connected;
	}
}
