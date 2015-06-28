package ba.bitcamp.homework17.part01.task03;

import ba.bitcamp.homework17.part01.task01.Computer;

/**
 * This class extends Computer class and contains one attribute. It will set
 * maximum number of computers in network.
 * 
 * @author Mladen13
 *
 */
public class Server extends Computer {

	private int maxNumOfComputers;

	/**
	 * This method will get maximum number of computers that can be connected to
	 * one server
	 * 
	 * @return - maxNumOfComputers
	 */
	public int getMaxNumOfComputers() {
		return maxNumOfComputers;
	}

	/**
	 * <h1>Constructor that initializes Computer name, mac address and maximum
	 * number of computers</h1>
	 * <p>
	 * 
	 * @param name
	 *            - represents Computer name (inherited from class computer)
	 * @param macAddress
	 *            - represents computer mac address (inherited from class
	 *            computer)
	 * @param maxNumOfComputers
	 *            - maximum number of computers
	 */
	public Server(String name, char[] macAddress, int maxNumOfComputers) {
		super(name, macAddress);
		this.maxNumOfComputers = maxNumOfComputers;
	}

	@Override
	public String toString() {
		return "Maximum number of computers on server: " + maxNumOfComputers;
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && super.equals(obj)
				&& maxNumOfComputers == ((Server) obj).maxNumOfComputers;
	}

}
