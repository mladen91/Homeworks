package ba.bitcamp.homeworkWeekend07.task2;

import java.util.EmptyStackException;

public class UniqueStackInt {

	private Node start;

	public UniqueStackInt() {
		start = null;
	}

	/**
	 * This method will add element on top of the stack
	 * 
	 * @param i
	 *            - added element
	 */
	public void push(Integer i) {
		if (start == null) {
			start = new Node(i);
		} else {
			if (!contains(i)) {
				Node first = new Node(i);

				first.setNextNode(start);
				start = first;
			}

		}
	}

	/**
	 * This method will remove element from stack
	 * 
	 * @return - element that will be removed
	 * @throws EmptyStackException
	 */
	public int pop() throws EmptyStackException {
		if (start == null) {
			throw new EmptyStackException();
		}
		Node temp = start;
		start = start.nextNode;
		return temp.getValue();
	}

	/**
	 * This method checks if our list is in increasing order
	 * 
	 * @return
	 */
	public boolean isIncreasing() {
		if (start == null) {
			return false;
		}

		Node temp = start;
		while (temp.getNextNode() != null) {
			if (temp.getValue() > temp.getNextNode().getValue()) {
				return false;
			}
			temp = temp.getNextNode();
		}
		return true;

	}

	public String toString() {
		if (start == null) {
			return "The stack is empty";
		}
		return start.toString();
	}

	/**
	 * Method that will check if list contains wanted element
	 * 
	 * @param b
	 *            - given element
	 * @return - true if element is found, false otherwise
	 */
	public boolean contains(Integer i) {
		if (start == null) {
			return false;
		}
		Node temp = start;
		while (temp.getNextNode() != null) {
			if (temp.getValue() == i) {
				return true;
			}
			temp = temp.getNextNode();
		}

		if (temp.getValue() == i) {
			return true;
		}
		return false;
	}

	/**
	 * This class contains two parameters, nextNode, and value. It is used for
	 * making new node into main class and passing nextNode values.
	 * 
	 * @author Mladen13
	 *
	 */
	public class Node {

		private Node nextNode;
		private Integer value;

		public Node(Integer value) {
			this.value = value;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public String toString() {
			if (nextNode == null) {
				return String.valueOf(value);
			}

			return value + " " + nextNode.toString();
		}
	}

	public static void main(String[] args) {
		UniqueStackInt t = new UniqueStackInt();
		t.push(5);
		t.push(3);
		t.push(2);
		t.push(2);
		t.push(7);
		t.pop();
		System.out.println(t);
		System.out.println(t.isIncreasing());

	}

}
