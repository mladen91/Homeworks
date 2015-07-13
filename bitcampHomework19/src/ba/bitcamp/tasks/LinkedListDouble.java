package ba.bitcamp.tasks;

/**
 * This class represents copy of linked list class, where we made few methods
 * that are used in linked list class.
 * 
 * @author Mladen13
 *
 */
public class LinkedListDouble {

	private Node start;
	private int counter;

	/**
	 * Default constructor that initializes start to null
	 */
	public LinkedListDouble() {
		start = null;
	}

	/**
	 * Constructor that copies one list to another
	 * 
	 * @param obj
	 *            - represents one linked list
	 */
	public LinkedListDouble(LinkedListDouble obj) {

		for (int i = 0; i < obj.size(); i++) {
			add(obj.get(i));
		}
	}

	/**
	 * Adding elements one by one to list
	 * 
	 * @param element
	 *            - represents values that will be added
	 */
	public void add(double element) {
		if (start == null) {
			start = new Node(element);
		} else {
			Node last = getLastNode();

			last.setNext(new Node(element));
		}
		counter++;
	}

	/**
	 * Removes element from list
	 * 
	 * @param index
	 *            - represents index of element that will be deleted
	 */
	public void remove(int index) {
		Node temp = start;

		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}

		Node previous = getPreviousNode(temp);
		previous.setNext(temp.getNext());

		counter--;
	}

	/**
	 * This method will get value of wanted index
	 * 
	 * @param index
	 *            - represents index where value will be taken
	 * @return - value of index
	 */
	public double get(int index) {
		Node temp = start;

		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}

		return temp.getValue();
	}

	/**
	 * This method shows us size of linked list
	 * 
	 * @return - size
	 */
	public int size() {
		return counter;
	}

	/**
	 * This method will get middle element from linked list
	 * 
	 * @return - middle element if possible, if not first element from left side
	 */
	public double getMiddle() {
		if (size() % 2 == 1) {
			return get(size() / 2);
		} else {
			return get(size() / 2 - 1);
		}
	}

	/**
	 * This method will get first element from list
	 * 
	 * @return - first element value
	 */
	public double getFirst() {
		return start.getValue();
	}

	/**
	 * This method will get last element from list
	 * 
	 * @return - last list element
	 */
	public double getLast() {
		return getLastNode().getValue();
	}

	/**
	 * This method will delete first element from linked list
	 */
	public void deleteFirst() {
		if (start == null) {
			return;
		} else {
			start = start.getNext();
		}
	}

	/**
	 * This method will delete last element from linked list
	 */
	public void deleteLast() {
		remove(size() - 1);
	}

	/**
	 * This method will add element on wanted index
	 * 
	 * @param d
	 *            - value that will be added on wanted index
	 * @param index
	 *            - represents index where value will be added
	 */
	public void add(double d, int index) {

		Node temp = start;
		int indexCounter = 0;
		// Index after which new node will be setted
		int targetIndex = index - 1;
		// Creating new node that will be inserted
		Node newNode = new Node(d);

		if (temp != null) {

			while (indexCounter < targetIndex && temp.getNext() != null) {

				indexCounter++;
				temp = temp.getNext();
			}

			if (indexCounter == targetIndex) {

				newNode.setNext(temp.getNext());
				temp.setNext(newNode);

			} else if (index == 0) {

				newNode.setNext(start);
				start = newNode;
			}

		} else if (index == 0) {

			start = newNode;
		}

	}

	/**
	 * This method will get us previous node of inserted node
	 * 
	 * @param n
	 *            - given node
	 * @return - previous node
	 */
	private Node getPreviousNode(Node n) {
		if (n == start) {
			return null;
		}

		Node temp = start;
		while (temp.getNext() != n) {
			temp = temp.getNext();
		}
		return temp;
	}

	/**
	 * This method will get last node for us
	 * 
	 * @return - last node
	 */
	private Node getLastNode() {
		if (start == null) {
			return null;
		}

		Node temp = start;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		return temp;

	}

	/**
	 * Printing list
	 */
	public String toString() {
		if (start == null) {
			return "The list is empty";
		}

		return start.toString();
	}

	/**
	 * This class is used for getting values and setting next node
	 * 
	 * @author Mladen13
	 *
	 */
	public class Node {
		private Node next;
		private double value;

		public Node(double value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}

		@Override
		public String toString() {
			if (next == null) {
				return value + "";
			}

			return value + " " + next.toString();
		}

	}
}
