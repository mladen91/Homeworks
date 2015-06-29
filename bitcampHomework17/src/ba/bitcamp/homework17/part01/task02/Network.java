package ba.bitcamp.homework17.part01.task02;

import ba.bitcamp.homework17.part01.task01.Computer;

/**
 * This class contains attributes that represents network name and array of
 * computers in our network.
 * 
 * @author Mladen13
 *
 */
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

	public Network(String networkName) {
		super();
		this.networkName = networkName;
		this.arrayComputer = new Computer[0];
	}

	/**
	 * This method will generate name of the network
	 * 
	 * @return - networkName
	 */
	public String getNetworkName() {
		return networkName;
	}

	/**
	 * This method will get array of computers in network, that will be used in
	 * BusNetwork and StarNetwork
	 * 
	 * @return
	 */
	public Computer[] getArrayComputer() {
		return arrayComputer;
	}

	/**
	 * This method will set new array of computer that will be used in
	 * BusNetwork and StarNetwork
	 * 
	 * @param arrayComputer
	 *            - represents array of computers in network
	 */
	public void setArrayComputer(Computer[] arrayComputer) {
		this.arrayComputer = arrayComputer;
	}

	/**
	 * Abstract method that will add one computer to network
	 * 
	 * @param c
	 *            - represents one Computer
	 */
	public abstract void addComputer(Computer c);

	/**
	 * Abstract method that will remove one computer from network
	 * 
	 * @param c
	 *            - represents one Computer
	 */
	public abstract void removeComputer(Computer c);
}
