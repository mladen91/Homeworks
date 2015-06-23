package ba.bitcamp.homework17.part02.task03;

import ba.bitcamp.homework17.part01.task01.Computer;
import ba.bitcamp.homework17.part01.task02.Network;
import ba.bitcamp.homework17.part01.task03.Server;
import ba.bitcamp.homework17.part01.task04.Client;
import ba.bitcamp.homework17.part02.task01.Functionable;
import ba.bitcamp.homework17.part02.task02.ArrayManipulation;

public class BusNetwork extends Network implements Functionable {

	private int counter;

	// Default generated constructor
	public BusNetwork(String networkName, Computer[] arrayComputer) {
		super(networkName, arrayComputer);

	}

	@Override
	// This method will check if our network is functioning
	public boolean isFunctioning() {
		counter = 0;
		for (int i = 0; i < getArrayComputer().length; i++) {
			if (getArrayComputer() != null) {
				counter++;
			}
		}
		if (counter >= 2) {
			return true;
		} else
			return false;
	}

	@Override
	// This method will add computer to network
	public void addComputer(Computer c) {
		// Extending array by one
		ArrayManipulation.extendArray(getArrayComputer());
		// putting new computer value into new extended array
		getArrayComputer()[getArrayComputer().length - 1] = c;
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
	// This method will remove computer from network
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
					return;
				}
			}
		}
		throw new IllegalArgumentException("Computer not found.");

	}

	// Method that prints number of computers, and checks if network is
	// functioning
	public String toString() {
		String s = "";

		s = "Number of computers on network: " + counter;
		s = s + "\nNetwork in function: " + isFunctioning();
		return s;
	}
}
