package ba.bitcamp.homework20.part01.task1;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Task1 {
	String[] arr;

	/**
	 * Default constructor that initializes array to 0
	 */
	public Task1() {
		arr = new String[0];
	}

	/**
	 * Pushes an item onto the top of this stack.
	 * 
	 * @param e
	 *            The String to be pushed onto this stack.
	 * @return The String argument.
	 */
	public void push(String e) {
		String[] newArr = Arrays.copyOf(arr, arr.length + 1);
		newArr[newArr.length - 1] = e;
		arr = newArr;
	}

	/**
	 * Removes the object at the top of this stack and returns that object as
	 * the value of this function.
	 * 
	 * @return The String at the top of this stack.
	 * @throws EmptyStackException
	 *             If this stack is empty.
	 */
	public String pop() throws EmptyStackException {
		if (arr.length == 0) {
			throw new EmptyStackException();
		}
		arr = Arrays.copyOf(arr, arr.length - 1);

		return arr[arr.length - 1];
	}

	/**
	 * Looks at the String at the top of this stack without removing it from the
	 * stack.
	 * 
	 * @return The String at the top of this stack.
	 * @throws EmptyStackException
	 *             If this stack is empty.
	 */
	public String peek() throws EmptyStackException {
		if (arr.length == 0) {
			throw new EmptyStackException();
		}
		return arr[arr.length - 1];
	}

	/**
	 * Tests if this stack is empty.
	 * 
	 * @return true if and only if this stack contains no items; false
	 *         otherwise.
	 */
	public boolean isEmpty() {
		return arr.length == 0;
	}

	/**
	 * Returns the 1-based position where an object is on this stack. If the
	 * String value occurs as an item in this stack, this method returns the
	 * distance from the top of the stack of the occurrence nearest the top of
	 * the stack; the topmost item on the stack is considered to be at distance
	 * 1. The equals method is used to compare value to the items in this stack.
	 * 
	 * @param s
	 *            The desired String.
	 * @return The 1-based position from the top of the stack where the object
	 *         is located; the return value -1 indicates that the object is not
	 *         on the stack.
	 */
	public int search(String s) {
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i].equals(s)) {
				return i;
			}
		}
		return -1;
	}

	public String toString() {
		return Arrays.toString(arr);
	}

	public static void main(String[] args) {

		// Testing class
		long start = System.currentTimeMillis();
		Task1 stack = new Task1();
		for (int i = 0; i < 10000000; i++) {
			stack.push("Names");
		}
		while (!stack.isEmpty()) {
			stack.pop();
		}
		System.out.println("It took: " + (System.currentTimeMillis() - start)
				+ " millis");

	}

}
