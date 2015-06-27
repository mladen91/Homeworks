package ba.bitcamp.homework17.part01.task04;

import ba.bitcamp.homework17.part01.task01.Computer;
import ba.bitcamp.homework17.part01.task02.Network;

public interface Connectable {

	/**
	 * This method will connect computer on network
	 * <p>
	 * 
	 * @param c
	 *            - represents one computer from class Computer
	 */
	void connect(Computer c);

	/**
	 * This method will connect network on link
	 * <p>
	 * 
	 * @param n
	 *            - represents network from class Network
	 */
	void connect(Network n);

	// Disconnects computer from network.
	void disconnect();
}
