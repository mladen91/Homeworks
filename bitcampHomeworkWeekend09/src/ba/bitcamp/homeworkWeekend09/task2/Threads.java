package ba.bitcamp.homeworkWeekend09.task2;

import java.util.Random;

/**
 * This class is used for printing lines using threads, with different sleeping
 * intervals.
 * 
 * @author Mladen13
 *
 */
public class Threads {

	public static void main(String[] args) {

		Thread t1 = new Thread(new MyThread());
		Thread t2 = new Thread(new MyThread());
		Thread t3 = new Thread(new MyThread());

		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This class implements Runnable and it uses run method to start our
	 * command
	 * 
	 * @author Mladen13
	 *
	 */
	static int counter = 0;

	public static class MyThread implements Runnable {

		@Override
		public void run() {
			if (counter == 0) {
				for (int i = 1; i < 11; i++) {
					System.out.println(i);

					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				counter++;
			} else if (counter == 1) {
				for (int i = 0; i < 4; i++) {
					System.out.println("BitCamp");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				counter++;
			} else if (counter == 2) {

				Random r = new Random();
				for (int i = 0; i < 5; i++) {
					System.out.println(r.nextInt(5));
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}

		}

	}
}
