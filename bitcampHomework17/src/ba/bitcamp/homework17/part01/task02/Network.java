package ba.bitcamp.homework17.part01.task02;

import ba.bitcamp.homework17.part01.task01.Computer;

public abstract class Network {

	private String networkName;
	private Computer[] arrayComputer;

	/**
	 * <h1>Constructor that adds network name and get array of computers</h1>
	 * <p>
	 * 
	 * @param networkName
	 *            - represents network name
	 * @param arrayComputer
	 *            - represents array of computers in network
	 * 
	 */

	public Network(String networkName, Computer[] arrayComputer) {
		this.networkName = networkName;
		this.arrayComputer = new Computer[0];
	}

	// Getters
	public String getNetworkName() {
		return networkName;
	}

	public Computer[] getArrayComputer() {
		return arrayComputer;
	}

	// Abstract method for adding computers
	public abstract void addComputer(Computer c);

	// Abstract method for removing computers
	public abstract void removeComputer(Computer c);
}
