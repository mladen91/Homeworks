package ba.bitcamp.homework20.part02.task1;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class DoubleQueue {
	Double[] arr;
	int size = 0;

	/**
	 * Default constructor that initializes array to null
	 */
	public DoubleQueue() {
		arr = new Double[0];
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

		Double[] newArr = Arrays.copyOf(arr, arr.length + 1);
		newArr[newArr.length - 1] = e;
		arr = newArr;
		size++;
		return true;
	}

	/**
	 * Retrieves and removes the head of this queue, or returns null if this
	 * queue is empty.
	 * 
	 * @return array value on index 0
	 */
	public Double poll() {
		if (arr.length == 0) {
			throw new NoSuchElementException();
		} else {
			double value = arr[0];
			arr = Arrays.copyOfRange(arr, 1, arr.length);
			size--;
			return value;
		}
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null
	 * if this queue is empty.
	 * 
	 * @return
	 */
	public Double peek() {
		if (arr.length == 0) {
			return null;
		} else {
			return arr[0];
		}
	}

	public boolean isEmpty() {
		size = 0;
		return arr.length == 0;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue. This method
	 * differs from peek only in that it throws an exception if this queue is
	 * empty.
	 * 
	 * @return
	 */
	public Double element() throws NoSuchElementException {
		if (arr.length == 0) {
			throw new NoSuchElementException();
		} else {
			return arr[0];
		}
	}

	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions. When using a
	 * capacity-restricted queue, this method is generally preferable to add(E),
	 * which can fail to insert an element only by throwing an exception.
	 * 
	 * @param e
	 * @return
	 */
	public boolean offer(Double e) {

		if (size == arr.length) {
			ensureCapacity();
		}
		arr[size++] = e;
		return true;
	}

	private void ensureCapacity() {
		int newSize = arr.length * 2;
		arr = Arrays.copyOf(arr, newSize);
	}

	/**
	 * Retrieves and removes the head of this queue.
	 * 
	 * @return
	 */
	public Double remove() throws NoSuchElementException {

		if (arr.length == 0) {
			throw new NoSuchElementException();
		} else {
			double value = arr[0];
			arr = Arrays.copyOfRange(arr, 1, arr.length);
			return value;
		}
	}

	public String toString() {
		return Arrays.toString(arr);
	}

	public static void main(String[] args) {

		// Testing class
		long start = System.currentTimeMillis();
		DoubleQueue queue = new DoubleQueue();
		for (int i = 0; i < 100000; i++) {
			queue.add(13.0);
		}
		while (!queue.isEmpty()) {
			queue.poll();
		}

		System.out.println("It took: " + (System.currentTimeMillis() - start)
				+ " millis");
	}

}
