package ba.bitcamp.homeworkWeekend07.task1;

/**
 * Class that represents simulation of linked list method using boolean values
 * 
 * @author Mladen13
 *
 */
public class LinkedListBoolean {

	private Node start;

	public LinkedListBoolean() {
		start = null;
	}

	/**
	 * This method will add element into linked list
	 * 
	 * @param b
	 *            - added element
	 */
	public void add(Boolean b) {
		if (start == null) {
			start = new Node(b);
		} else {
			Node last = getLastNode();
			last.setNextNode(new Node(b));
		}
	}

	/**
	 * This method will remove element from linked list
	 * 
	 * @param b
	 *            - removed element
	 */
	public void remove(Boolean b) {

		Node temp = start;

		for (int i = 0; i < getLength(); i++) {
			if (temp.getValue() == b) {
				break;
			} else {
				temp = temp.getNextNode();
			}
		}
		Node previous = getPreviousNode(temp);
		previous.setNextNode(temp.getNextNode());
	}

	/**
	 * This method will remove given element after given index
	 * 
	 * @param index
	 *            - given index
	 * @param b
	 *            - element that will be removed first
	 */
	public void remove(int index, Boolean b) {

		Node temp = start;

		for (int i = 0; i < index; i++) {
			temp = temp.getNextNode();
		}

		for (int i = index; i < getLength(); i++) {
			if (temp.getNextNode().getValue() == b) {
				temp = temp.getNextNode();
				break;
			} else {
				temp = temp.getNextNode();
			}
		}
		Node previous = getPreviousNode(temp);
		previous.setNextNode(temp.getNextNode());
	}

	/**
	 * Method that will check if list contains wanted element
	 * 
	 * @param b
	 *            - given element
	 * @return - true if element is found, false otherwise
	 */
	public boolean contains(Boolean b) {
		if (start == null) {
			return false;
		}
		Node temp = start;
		while (temp.getNextNode() != null) {
			if (temp.getValue() == b) {
				return true;
			}
			temp = temp.getNextNode();
		}
		return false;
	}

	/**
	 * This method will check if our linked list is alternating
	 * 
	 * @return - true if it is, false otherwise
	 */
	public boolean isAlternating() {
		if (start == null) {
			return false;
		}

		Node temp = start;

		while (temp.getNextNode() != null) {
			if (temp.getValue() == temp.getNextNode().value) {
				return false;
			}
			temp = temp.getNextNode();
		}
		return true;
	}

	/**
	 * This method will return previous node from given element.
	 * 
	 * @param n
	 *            - given element
	 * @return - previous node
	 */
	private Node getPreviousNode(Node n) {
		if (n == start) {
			return null;
		}

		Node temp = start;
		while (temp.getNextNode() != n) {
			temp = temp.getNextNode();
		}
		return temp;
	}

	/**
	 * This method will return last node from list
	 * 
	 * @return
	 */
	private Node getLastNode() {
		if (start == null) {
			return null;
		}
		Node temp = start;
		while (temp.getNextNode() != null) {
			temp = temp.getNextNode();
		}
		return temp;
	}

	/**
	 * This method will return linked list size/length
	 * 
	 * @return
	 */
	public int getLength() {
		int length = 0;

		Node current = start;

		while (current.getNextNode() != null) {
			length += 1;
			current = current.getNextNode();
		}
		return length;
	}

	public String toString() {
		if (start == null) {
			return "The list is empty";
		}
		return start.toString();
	}

	/**
	 * Class that contains two parameters, and toString method.
	 * 
	 * @author Mladen13
	 *
	 */
	public class Node {

		private Node nextNode;
		private Boolean value;

		public Node(Boolean value) {
			this.value = value;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public Boolean getValue() {
			return value;
		}

		public void setValue(Boolean value) {
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
		LinkedListBoolean t = new LinkedListBoolean();
		t.add(true);
		t.add(false);
		t.add(true);
		t.add(false);
		t.add(true);
		t.add(false);
		t.add(true);
		t.add(false);
		t.remove(1, false);
		System.out.println("Does it contains: " + t.contains(false));
		System.out.println(t);
		System.out.println("Is this list alternating: " + t.isAlternating());
	}

}
