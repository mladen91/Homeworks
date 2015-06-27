package ba.bitcamp.homework17.part01.task04;

import ba.bitcamp.homework17.part01.task01.Computer;
import ba.bitcamp.homework17.part01.task02.Network;

public class Client extends Computer implements Connectable {

	private Computer connectedWith;
	private Network whichNetworkConnected;

	/**
	 * <h1>Creating constructor that initializes computer name and mac address.</h1>
	 * 
	 * @param name
	 *            - represents computer name (inherited from class Computer)
	 * @param macAddress
	 *            - represents mac address (inherited from class Computer)
	 */
	public Client(String name, char[] macAddress) {
		super(name, macAddress);
	}

	// Getters
	public Computer getConnectedWith() {

		return connectedWith;
	}

	public Network getWhichNetworkConnected() {
		return whichNetworkConnected;
	}

	// Method that connects two computers
	@Override
	public void connect(Computer c) {
		if (connectedWith != null || whichNetworkConnected != null) {
			throw new IllegalArgumentException("Error");
		} else
			connectedWith = c;

	}

	// Method that gives link to network
	@Override
	public void connect(Network n) {
		if (connectedWith != null || whichNetworkConnected != null) {
			throw new IllegalArgumentException("Error");
		} else
			whichNetworkConnected = n;

	}

	// Disconnects computer from network
	@Override
	public void disconnect() {
		whichNetworkConnected = null;
		connectedWith = null;
	}

	@Override
	public String toString() {
		return "Client is connected with: " + connectedWith + ", on network: "
				+ whichNetworkConnected;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (connectedWith == null) {
			if (other.connectedWith != null)
				return false;
		} else if (!connectedWith.equals(other.connectedWith))
			return false;
		if (whichNetworkConnected == null) {
			if (other.whichNetworkConnected != null)
				return false;
		} else if (!whichNetworkConnected.equals(other.whichNetworkConnected))
			return false;
		return true;
	}

}
