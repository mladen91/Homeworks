package ba.bitcamp.homework17.part01.task04;

import ba.bitcamp.homework17.part01.task01.Computer;
import ba.bitcamp.homework17.part01.task02.Network;

/**
 * This class extends Computer class and implements Connectable interface It
 * contains two attributes and connect and disconnect method that are
 * implemented by interface.
 * 
 * @author Mladen13
 *
 */
public class Client extends Computer implements Connectable {

	private Computer connectedComputer;
	private Network connectedNetwork;

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

	/**
	 * This method will get connected computer
	 * 
	 * @return - return connected computer
	 */
	public Computer getConnectedComputer() {

		return connectedComputer;
	}

	/**
	 * This method will get connected network
	 * 
	 * @return - return connected network
	 */
	public Network getConnectedNetwork() {
		return connectedNetwork;
	}

	/**
	 * This method will connect two computers.
	 */
	@Override
	public void connect(Computer c) {
		if (connectedComputer != null || connectedNetwork != null) {
			throw new IllegalArgumentException(
					"Error while connecting to computer. Link to computer already exists.");
		} else
			connectedComputer = c;

	}

	/**
	 * This method will give link to network.
	 */
	@Override
	public void connect(Network n) {
		if (connectedComputer != null || connectedNetwork != null) {
			throw new IllegalArgumentException(
					"Error while connecting to network. Link to network already exists.");
		} else
			connectedNetwork = n;

	}

	/**
	 * This method disconnects computer from network.
	 */
	@Override
	public void disconnect() {
		connectedNetwork = null;
		connectedComputer = null;
	}

	@Override
	public String toString() {
		return "Client is connected with: " + connectedComputer
				+ ", on network: " + connectedNetwork;
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
		if (connectedComputer == null) {
			if (other.connectedComputer != null)
				return false;
		} else if (!connectedComputer.equals(other.connectedComputer))
			return false;
		if (connectedNetwork == null) {
			if (other.connectedNetwork != null)
				return false;
		} else if (!connectedNetwork.equals(other.connectedNetwork))
			return false;
		return true;
	}

}
