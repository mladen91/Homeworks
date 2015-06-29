package ba.bitcamp.homework17.part01.task01;

import java.util.Arrays;

/**
 * Class that represents Computer. Parts of computer are computer name, and mac
 * address.
 * 
 * @author Mladen13
 *
 */
public abstract class Computer {
	private String name;
	private MACAddress macAddress;

	/**
	 * Creating constructor for generating name and address
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

	/**
	 * This constructor sets default computer name, and sets mac address to
	 * null.
	 */
	public Computer() {

		this.name = "Default Computer";
		
	}

	/**
	 * This method will get name of computer
	 * 
	 * @return - computer name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method will get computer MAC address
	 * 
	 * @return - macAddress
	 */
	public String getMacAddress() {
		return macAddress.toString();
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
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MACAddress other = (MACAddress) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (!Arrays.equals(mac, other.mac))
				return false;
			return true;
		}
		private Computer getOuterType() {
			return Computer.this;
		}
		
		

	}
}
