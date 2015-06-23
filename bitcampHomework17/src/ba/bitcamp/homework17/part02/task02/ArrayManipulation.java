package ba.bitcamp.homework17.part02.task02;

import java.util.Arrays;

import ba.bitcamp.homework17.part01.task01.Computer;

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
		Computer[] compArray = new Computer[c.length - 1];
		int j = 0;
		for (int i = 0; i < compArray.length; i++) {

			if (j == idx) {
				j++;
			}
			compArray[i] = c[j];
			j++;
		}
		return compArray;
	}
}
