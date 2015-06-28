package ba.bitcamp.homework17.part02.task02;

import ba.bitcamp.homework17.part01.task01.Computer;

/**
 * This class contains two methods that will extend array by one element, and
 * other class that will shrink array by one.
 * 
 * @author Mladen13
 *
 */
public class ArrayManipulation {

	/**
	 * This method will extend array by one
	 * 
	 * @param c
	 *            -represents array of computers
	 */
	public static Computer[] extendArray(Computer[] c) {

		Computer[] compArray = new Computer[c.length + 1];

		for (int i = 0; i < c.length; i++) {
			compArray[i] = c[i];
		}
		return compArray;
	}

	/**
	 * This method will shrink array by one
	 * 
	 * @param c
	 *            -represents array of computers
	 * @param idx
	 *            - represents index of computer that will be decreased
	 */
	public static Computer[] shrinkArray(Computer[] c, int idx) {

		if (c == null) {
			throw new NullPointerException(
					"There is no computers in your array");
		} else {

			Computer[] compArray = new Computer[c.length - 1];

			for (int i = 0; i < compArray.length; i++) {

				if (i < idx) {
					compArray[i] = c[i];
				} else {
					compArray[i] = c[i + 1];
				}
			}
			return compArray;
		}
	}
}
