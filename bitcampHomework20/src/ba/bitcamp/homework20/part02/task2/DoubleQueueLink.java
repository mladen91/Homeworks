package ba.bitcamp.homework20.part02.task2;

public class DoubleQueueLink {

	private Node start;
	private Node finish;

	/**
	 * Default constructor that initializes start and finish nodes to null.
	 */
	public DoubleQueueLink() {
		start = null;
		finish = null;
	}

	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions, returning true upon
	 * success and throwing an IllegalStateException if no space is currently
	 * available
	 * 
	 * @param e
	 * @return
	 */
	public boolean add(Double e) {

		Node n = new Node(e);

		if (start == null) {
			start = n;
			finish = n;
		} else if (start == finish) {
			n.previousNode = start;
			finish = n;
			start.nextNode = n;
		} else {
			finish.nextNode = n;
			n.previousNode = finish;
			finish = n;
		}
		return true;

	}

	public String toString() {
		if (start == null) {
			return "The list is empty";
		}

		return start.toString();
	}

	/**
	 * Retrieves and removes the head of this queue, or returns null if this
	 * queue is empty.
	 * 
	 * @return list value on index 0
	 */
	public Double poll() {

		if (start == null) {
			return null;
		}
		Double temp = start.getValue();
		start = start.getNextNode();
		return temp;

	}

	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null
	 * if this queue is empty.
	 * 
	 * @return
	 */
	public Double peek() {

		if (start == null) {
			return null;
		}

		return start.getValue();
	}

	public class Node {
		private Double value;
		private Node nextNode;
		private Node previousNode;

		public Node getPreviousNode() {
			return previousNode;
		}

		public void setPreviousNode(Node previousNode) {
			this.previousNode = previousNode;
		}

		public Node(Double value) {
			this.value = value;
		}

		public Double getValue() {
			return value;
		}

		public void setValue(Double value) {
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
				return value.toString();
			}
			return value + " " + nextNode.toString();
		}
	}

	public static void main(String[] args) {

		// Testing class
		long start = System.currentTimeMillis();
		DoubleQueueLink queue = new DoubleQueueLink();
		for (int i = 0; i < 100000; i++) {
			queue.add(15.5);
		}

		while (queue.start != null) {
			queue.poll();
		}
		System.out.println("It took: " + (System.currentTimeMillis() - start)
				+ " millis");

	}

}
