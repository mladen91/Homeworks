package ba.bitcamp.homework17.part01.task03;

import ba.bitcamp.homework17.part01.task01.Computer;

public class Server extends Computer {

	private int maxNumOfComputers;

	// Getter and setter
	public int getMaxNumOfComputers() {
		return maxNumOfComputers;
	}

	public void setMaxNumOfComputers(int maxNumOfComputers) {
		this.maxNumOfComputers = maxNumOfComputers;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		if (maxNumOfComputers != other.maxNumOfComputers)
			return false;
		return true;
	}

}
