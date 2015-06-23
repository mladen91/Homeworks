package ba.bitcamp.homework17.part02.task04;

import ba.bitcamp.homework17.part01.task01.Computer;
import ba.bitcamp.homework17.part01.task02.Network;
import ba.bitcamp.homework17.part01.task03.Server;
import ba.bitcamp.homework17.part01.task04.Client;
import ba.bitcamp.homework17.part02.task01.Functionable;
import ba.bitcamp.homework17.part02.task02.ArrayManipulation;

public class StarNetwork extends Network implements Functionable {

	private int counter = 0;
	private Server s;

	/**
	 * <h1>Creating constructor that initializes server</h1>
	 * <p>
	 * 
	 * @param networkName
	 *            - represents name of the network
	 * @param arrayComputer
	 *            - array of computers on network
	 * @param s
	 *            - represents server
	 */
	public StarNetwork(String networkName, Computer[] arrayComputer, Server s) {
		super(networkName, arrayComputer);
		this.s = s;
	}

	// This method checks if our network is in function
	// Network is in function when number of computer on network is lower than
	// server capacity
	@Override
	public boolean isFunctioning() {
		counter = 0;
		for (int i = 0; i < getArrayComputer().length; i++) {
			if (getArrayComputer()[i] != null) {
				counter++;
			}
		}
		if (s.getMaxNumOfComputers() <= counter) {
			return false;
		} else {
			return true;
		}
	}

	// This method will connect computer to server
	@Override
	public void addComputer(Computer c) {

		if (c instanceof Server) {
			throw new IllegalArgumentException("You can't add server.");
		} else {
			// Extending our array by one
			ArrayManipulation.extendArray(getArrayComputer());
			getArrayComputer()[getArrayComputer().length - 1] = c;
			if (c instanceof Client) {
				Client cl = (Client) c;
				// Connecting computer to server
				cl.connect(s);
			}
		}
	}

	// This method will remove one computer from network
	@Override
	public void removeComputer(Computer c) {
		if (c instanceof Client) {
			Client cl = (Client) c;
			for (int i = 0; i < getArrayComputer().length; i++) {
				// Checking if there is wanted computer in our computer array
				if (getArrayComputer()[i].getName().equals(cl.getName())) {
					cl.disconnect();
					ArrayManipulation.shrinkArray(getArrayComputer(), i);
					return;
				}
			}
		} else {
			throw new IllegalArgumentException("You can't remove server.");
		}
		throw new IllegalArgumentException("Computer not found!");

	}

	// Method that prints number of computers, and checks if network is
	// functioning
	public String toString() {
		String s = "";

		s = "Number of computers on server: " + counter;
		s = s + "\nNetwork in function: " + isFunctioning();
		return s;
	}

}
