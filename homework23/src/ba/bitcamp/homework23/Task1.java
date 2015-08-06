package ba.bitcamp.homework23;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This class is used for counting first letter from file using consumer
 * producer metodology
 * 
 * @author Mladen13
 *
 */
public class Task1 {
    //Declaring global variables
	private static BufferedReader br = null;
	private static Integer counter = 0;
	private static LinkedBlockingQueue<Runnable> queue;
	private static ArrayList<Producer> producers;
	private static ArrayList<String> firstLetters;

	public static void main(String[] args) {

		queue = new LinkedBlockingQueue<Runnable>();
		firstLetters = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(new File("text.txt")));
			String lineTask = "";
			// Reading lines from file, and adding them to queue
			while ((lineTask = br.readLine()) != null) {
				firstLetters.add(Character.toString(lineTask.charAt(0)));

				queue.add(new Task(lineTask));
			}

			producers = new ArrayList<>();
			// Starting and adding producer
			for (int i = 0; i < 1; i++) {
				Producer p = new Producer();
				p.start();
				try {
					p.join();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				producers.add(p);
			}

			System.out.println("There is " + counter
					+ " repetitions of letter " + firstLetters.get(0)
					+ " in file");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Class that takes job from queue and does it
	 * 
	 * @author Mladen13
	 *
	 */
	static class Producer extends Thread {

		@Override
		public void run() {
			while (!queue.isEmpty()) {
				try {
					Runnable job = queue.take();
					job.run();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	/**
	 * Class that represents job that is done line by line
	 * 
	 * @author Mladen13
	 *
	 */
	static class Task implements Runnable {

		String line = "";

		public Task(String line) {
			this.line = line;
		}

		@Override
		public void run() {

			for (int i = 0; i < line.length(); i++) {

				if (firstLetters.get(0).equalsIgnoreCase(
						Character.toString(line.charAt(i)))) {
					synchronized (counter) {
						counter++;
					}

				}
			}

		}

	}
}
