package ba.bitcamp.homeworkWeekend09.task3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class is used for creating GUI application that will pause and resume
 * printing alphabet on frame.
 * 
 * @author Mladen13
 *
 */
public class ThreadGui extends JFrame {

	private static final long serialVersionUID = -1307032068635590495L;

	private JLabel label = new JLabel();
	private JButton pause = new JButton("Pause");
	private JButton resume = new JButton("Resume");

	private MyThread thread;

	/**
	 * Basic constructor that creates thread on label, and uses action listeners
	 * for pausing and resuming print.
	 */
	public ThreadGui() {

		thread = new MyThread(label);
		thread.start();
		// Pausing print using method from MyThread class
		pause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					thread.pauseThread();
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}

			}
		});
		// Resuming print using method from MyThread class
		resume.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thread.resumeThread();

			}
		});

		setLayout(new BorderLayout());
		// Adding components on frame
		add(label, BorderLayout.CENTER);
		add(pause, BorderLayout.SOUTH);
		add(resume, BorderLayout.NORTH);

		setSize(500, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	/**
	 * This class extends Thread class and it has methods for resuming and
	 * pausing print alphabet.
	 * 
	 * @author Mladen13
	 *
	 */
	private class MyThread extends Thread {

		private JLabel label;

		private boolean running = true;

		/**
		 * Default constructor that initialize label value
		 * 
		 * @param label
		 *            - label from JLabel class
		 */
		public MyThread(JLabel label) {

			this.label = label;
		}

		@Override
		public void run() {
			String s = "";
			// Declaring letter a as int
			int letter = 97;

			for (int i = 0; i < 1000; i++) {
				// casting int to char
				s += " " + (char) letter;
				// pausing thread
				while (!running) {
					yield();
				}

				label.setText(s);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// Reseting letter to a when it comes to z
				if (letter < 122) {
					letter++;
				} else {
					letter = 97;
				}
			}
		}

		/**
		 * Method that pauses thread with setting running to false
		 * 
		 * @throws InterruptedException
		 */
		public void pauseThread() throws InterruptedException {

			running = false;
		}

		/**
		 * Method that resumes thread with setting running to true
		 */
		public void resumeThread() {

			running = true;
		}
	}

	public static void main(String[] args) {

		new ThreadGui();

	}

}