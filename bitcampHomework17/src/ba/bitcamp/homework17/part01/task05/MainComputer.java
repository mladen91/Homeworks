package ba.bitcamp.homework17.part01.task05;

import ba.bitcamp.homework17.part01.task01.Computer;
import ba.bitcamp.homework17.part01.task03.Server;
import ba.bitcamp.homework17.part01.task04.Client;

public class MainComputer {

	public static void main(String[] args) {

		// Creating two mac addresses
		char[] m1 = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'a', 'b' };
		char[] m2 = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'c', 'b' };
		// Creating client
		Client c1 = new Client("PC1", m1);
		Client c2 = new Client("PC2", m2);
		// Getting mac address from c1
		System.out.println(c1.getMacAddress());

		Computer[] arrComp = new Computer[2];
		Server s1 = new Server("PC", m1, 3);
		arrComp[0] = c1;
		arrComp[1] = c2;
		// Connecting client to server
		c1.connect(s1);
		// Disconnecting client from server
		c1.disconnect();
		c1.connect(s1);
		// Printing client status
		System.out.println(c1);

	}
}
