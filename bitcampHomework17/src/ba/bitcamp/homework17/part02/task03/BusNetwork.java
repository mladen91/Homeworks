package ba.bitcamp.homework17.part02.task03;

import ba.bitcamp.homework17.part01.task01.Computer;
import ba.bitcamp.homework17.part01.task02.Network;
import ba.bitcamp.homework17.part01.task03.Server;
import ba.bitcamp.homework17.part01.task04.Client;
import ba.bitcamp.homework17.part02.task01.Functionable;
import ba.bitcamp.homework17.part02.task02.ArrayManipulation;

/**
 * This class extends Network class, and it contains method from interface
 * functionable.
 * 
 * @author Mladen13
 *
 */
public class BusNetwork extends Network implements Functionable {

	private int counter;

	/**
	 * Constructor that initializes network name, which is inherited from class
	 * Network
	 * 
	 * @param networkName
	 *            - represents name of network
	 */
	public BusNetwork(String networkName) {
		super(networkName);
	}

	@Override
	/**
	 * This method will check if our network is in function
	 */
	public boolean isFunctioning() {
		counter = 0;
		for (int i = 0; i < getArrayComputer().length; i++) {
			if (getArrayComputer()[i] != null) {
				counter++;
			}
		}
		if (counter > 1) {
			return true;
		} else
			return false;
	}

	@Override
	/**
	 * This method will add computer to network, which is implemented from interface Connectable
	 */
	public void addComputer(Computer c) {
		// Extending array by one
		Computer[] cmp = ArrayManipulation.extendArray(getArrayComputer());
		// putting new computer value into new extended array
		cmp[cmp.length - 1] = c;
		setArrayComputer(cmp);
		// if computer is server we can't add it to network
		if (c instanceof Server) {
			throw new IllegalArgumentException("You can't add server.");
			// if computer is client, we will add it, and connect it to network.
		} else if (c instanceof Client) {
			Client comp = (Client) c;
			comp.connect(this);
		}
	}

	@Override
	/**
	 * This method will remove computer from network, which is implemented from interface Connectable
	 */
	public void removeComputer(Computer c) {
		// If computer is server, we can't remove it.
		if (c instanceof Server) {
			throw new IllegalArgumentException("You can't remove server.");
		} else if (c instanceof Client) {
			Client comp = (Client) c;
			// Before removing computer, we need to disconnect it from network
			// first.
			comp.disconnect();

			for (int i = 0; i < getArrayComputer().length; i++) {
				// if we find wanted computer name in array, we will remove that
				// computer
				if (c.getName().equals(getArrayComputer()[i].getName())) {
					ArrayManipulation.shrinkArray(getArrayComputer(), i);
					setArrayComputer(ArrayManipulation.shrinkArray(
							getArrayComputer(), i));
					return;
				}
			}
		}
		throw new IllegalArgumentException("Computer not found.");

	}

	/**
	 * Method that prints number of computers, and checks if network is
	 * functioning
	 */
	public String toString() {

		return "Number of computers on network: " + getArrayComputer().length
				+ "\nNetwork in function: " + isFunctioning();
	}
}
