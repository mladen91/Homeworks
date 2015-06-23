package ba.bitcamp.homework17.part01.task01;

import java.util.Arrays;

/**
 * Class that represents Computer. Parts of computer are computer name, and mac
 * address.
 * 
 * @author Mladen13
 *
 */
public class Computer {
	private String name;
	private MACAddress macAddress;

	/**
	 * Creating constructor for generating name and mac address
	 * 
	 * @param name
	 *            - represents computer name
	 * @param macAddress
	 *            - represents computer mac address
	 */
	public Computer(String name, char[] macAddress) {
		this.name = name;
		this.macAddress = new MACAddress(macAddress);
	}

	// Empty constructor that defines default name, and mac address
	public Computer() {

		this.name = "Default Computer";
		this.macAddress = null;
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMacAddress() {
		return macAddress.toString();
	}

	public void setMacAddress(MACAddress macAddress) {
		this.macAddress = macAddress;
	}

	/**
	 * MAC Address class that defines mac address
	 * 
	 * @author mladen.teofilovic
	 *
	 */
	public class MACAddress {
		// 0123456789ab
		private char[] mac = new char[12];

		public MACAddress(char[] mac) {
			this.mac = mac;
		}

		@Override
		// 01:23:45:67:89:ab
		public String toString() {
			String s = "";
			int counter = 2;
			for (int i = 0; i < mac.length; i++) {
				if (i == counter) {
					s += ":";
					counter += 2;
				}
				s += mac[i];
			}
			return s;

		}

	}
}
