package ba.bitcamp.homework17.part02.task05;

import ba.bitcamp.homework17.part01.task03.Server;
import ba.bitcamp.homework17.part01.task04.Client;
import ba.bitcamp.homework17.part02.task03.BusNetwork;
import ba.bitcamp.homework17.part02.task04.StarNetwork;

public class MainComputer2 {

	public static void main(String[] args) {

		// Creating mac addresses
		char[] m1 = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'a', 'b' };
		char[] m2 = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'c', 'b' };
		char[] m3 = new char[] { '0', '2', '1', '3', '4', '5', '6', '7', '8',
				'9', 'd', 'b' };

		// Creating client
		Client c1 = new Client("PC1", m1);
		Client c2 = new Client("PC2", m2);
		Client c3 = new Client("PC2", m3);
		Client c4 = new Client("PC2", m3);

		Server s1 = new Server("PC", m1, 5);

		StarNetwork sn1 = new StarNetwork("Network", s1);

		sn1.addComputer(c1);
		sn1.addComputer(c2);

		System.out.println(sn1);

		BusNetwork bn1 = new BusNetwork("Bus Network");
		bn1.addComputer(c3);
		bn1.addComputer(c4);
		System.out.println(bn1);

	}

}
