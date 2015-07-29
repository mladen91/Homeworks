package ba.bitcamp.homeworkWeekend07.task3;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Task3 {

	// Setting number of elements in list as constant
	private static final int NUMBEROFELEMENTS = 7;
	

	public static void main(String[] args) {
		ArrayList<Integer> numList = new ArrayList<Integer>();
		Random r = new Random();
		// Filling list with random numbers from 0 to 10
		for (int i = 0; i < NUMBEROFELEMENTS; i++) {
			numList.add(r.nextInt(10));
		}
		System.out.println(numList);
		// Getting last element of list
		int lastNum = numList.get(numList.size() - 1);
		// Making list iterator
		ListIterator<Integer> iter = numList.listIterator();
		int i = 0;
		// Summing numbers using iterator
		while (iter.hasNext()) {

			if (i < numList.size() - 1) {
				iter.add(numList.get(i) + numList.get(i + 1));

			}
			iter.next();
			iter.remove();
			i += 2;
		}
		// Adding last number to final list if number of elements is odd.
		if (NUMBEROFELEMENTS % 2 == 1) {
			numList.add(lastNum);
		}
		System.out.println(numList);

	}
}