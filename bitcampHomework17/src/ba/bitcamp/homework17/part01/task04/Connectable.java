package ba.bitcamp.homework17.part01.task04;

import ba.bitcamp.homework17.part01.task01.Computer;
import ba.bitcamp.homework17.part01.task02.Network;

/**
 * Interface that contains two connect methods, and one disconnect method.
 * 
 * @author Mladen13
 *
 */
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

	/**
	 * This method disconnects computer from network
	 */
	void disconnect();
}
