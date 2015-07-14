package ba.bitcamp.homework20.part02.task1;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class DoubleQueue {
	Double[] arr;

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
			return null;
		} else {
			Double temp = arr[1];
			Double[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
			newArr[0] = temp;
			arr = newArr;

			return arr[1];
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

		Double[] newArr = Arrays.copyOf(arr, arr.length + 1);
		newArr[newArr.length - 1] = e;
		arr = newArr;
		return true;
	}

	/**
	 * Retrieves and removes the head of this queue.
	 * 
	 * @return
	 */
	public Double remove() {
		Double temp = arr[1];
		Double[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
		newArr[0] = temp;
		arr = newArr;

		return arr[1];
	}

	public String toString() {
		return Arrays.toString(arr);
	}

	public static void main(String[] args) {

		// Testing class
		long start = System.currentTimeMillis();
		DoubleQueue queue = new DoubleQueue();
		for (int i = 0; i < 1000000; i++) {
			queue.add(13.0);
		}
		while (queue.arr != null) {
			queue.poll();
		}
		System.out.println(queue);
		System.out.println("It took: " + (System.currentTimeMillis() - start)
				+ " millis");
	}

}
