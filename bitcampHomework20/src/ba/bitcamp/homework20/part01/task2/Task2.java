package ba.bitcamp.homework20.part01.task2;

import java.util.EmptyStackException;

public class Task2 {

	private Node start;

	/**
	 * Default constructor that initializes start to null
	 */
	public Task2() {
		start = null;
	}

	/**
	 * Pushes an item onto the top of this stack.
	 * 
	 * @param e
	 *            The String to be pushed onto this stack.
	 * @return The String argument.
	 */
	public void push(String e) {

		if (start == null) {
			start = new Node(e);
		} else {
			Node first = new Node(e);
			first.setNextNode(start);
			start = first;
		}

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
		String value = start.getValue();
		if (start == null) {
			throw new EmptyStackException();
		}
		start = start.getNextNode();

		return value;
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

		if (start == null) {
			throw new EmptyStackException();
		}

		return start.getValue();
	}

	/**
	 * Tests if this stack is empty.
	 * 
	 * @return true if and only if this stack contains no items; false
	 *         otherwise.
	 */
	public boolean isEmpty() {
		return start == null;
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
		if (start == null) {
			return -1;
		}
		int counter = 0;
		Node temp = start;

		while (temp.getNextNode() != null) {
			counter++;
			if (temp.getValue().equals(s)) {
				return counter;
			}
			temp = temp.getNextNode();

		}

		return -1;
	}

	public String toString() {
		if (start == null) {
			return "The list is empty";
		}

		return start.toString();
	}

	/**
	 * Class that contains value and next node, getters and setters
	 * 
	 * @author Mladen13
	 *
	 */
	public class Node {
		private String value;
		private Node nextNode;

		public Node(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public String toString() {
			if (nextNode == null) {
				return value;
			}
			return value + " " + nextNode.toString();
		}
	}

	public static void main(String[] args) {

		// Testing class
		long start = System.currentTimeMillis();
		Task2 stack = new Task2();
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
