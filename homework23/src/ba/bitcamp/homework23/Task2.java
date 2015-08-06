package ba.bitcamp.homework23;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class extends JFrame and it is used for making negative from readed
 * picture. Picture is being shown using GUI
 * 
 * @author Mladen13
 *
 */
public class Task2 extends JFrame {
	// Declaring variables
	private static final long serialVersionUID = -5118980704703412553L;
	private static BufferedImage img = null;
	private JPanel panel;
	private static LinkedBlockingQueue<Runnable> queue;
	private static ArrayList<Worker> slaves;
	private static int a = 0;
	private static int b = 10;

	public static void main(String[] args) {
		new Task2();
	}

	/**
	 * Default constructor that initializes and sets gui components
	 */
	public Task2() {
		importPicture();
		panel = new MyPanel();
		add(panel);

		setSize(1920, 1080);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Negativ Task");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		queue = new LinkedBlockingQueue<Runnable>();
		// Adding new tasks to queue
		for (int i = 0; i < 150; i++) {

			queue.add(new Task(a, b));
			a += 10;
			b += 10;

		}

		slaves = new ArrayList<>();
		// Adding workers
		for (int i = 0; i < 8; i++) {
			Worker s = new Worker();
			s.start();
			try {
				s.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			slaves.add(s);
		}

	}

	/**
	 * This class represents task that is proceeded to one of eight workers
	 * 
	 * @author Mladen13
	 *
	 */
	static class Task implements Runnable {

		private int a;
		private int b;

		public Task(int a, int b) {
			this.a = a;
			this.b = b;

		}

		@Override
		public void run() {

			for (int i = a; i < b; i++) {
				for (int j = 0; j < img.getHeight(); j++) {
					int pixel = img.getRGB(i, j);
					img.setRGB(i, j, 255 - pixel);

				}

			}

		}

	}

	/**
	 * Class that is used for taking jobs until queue is empty
	 * 
	 * @author Mladen13
	 *
	 */
	static class Worker extends Thread {
		@Override
		public void run() {
			while (!queue.isEmpty()) {
				try {
					Runnable job = queue.take();

					job.run();
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}

	/**
	 * Method that reads picture from file
	 */
	public void importPicture() {
		try {
			img = ImageIO.read(new File("wallpaper.jpg"));

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Class that is used for drawing picture on panel
	 * 
	 * @author Mladen13
	 *
	 */
	public class MyPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);
			repaint();
		}

	}

}
