package homework24;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This class contains many methods that will be used in Snake game(Single
 * Player mode). Timer is used for making our snake to move. Keyboard keys up,
 * down, left and right are used for movement. Game is finished when snake hits
 * itself, or it hits wall, and that is checked in checkCollision() method After
 * every byte, new food is generated using eatedFood() method.
 * 
 * @author Mladen13
 *
 */
public class GamePanel extends JPanel {

	private static final long serialVersionUID = 8782463055072321942L;
	private static final int HEIGHT = 600;
	private static final int WIDTH = 800;
	private static final int MAXDOTS = 1000;
	private static final int MAXFOODFIELD = 59;
	private static final int TILESIZE = 10;
	// Snake arrays for X and Y coordinates

	private static ArrayList<Snake> snakes = new ArrayList<>();

	// Snake size
	private int size = 3;
	// Food x and y coordinates
	private int foodX;
	private int foodY;
	// This variables will be used for changing directions
	private boolean left = false;
	private boolean right = true;
	private boolean up = false;
	private boolean down = false;
	private int score = 0;
	// Creating timer
	private Timer t;
	private int gameSpeed = 1;
	private int delay = 50;

	BufferedWriter bw = null;

	/**
	 * Constructor where we will create snake and add timer.
	 */
	public GamePanel() {

		// Adding key listener that will move snake
		addKeyListener(new KeyHandler());
		setFocusable(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		// Calling method that will set food on random panel position
		generateFood();
		// Initializing timer with action listener
		t = new Timer(delay, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Calling method where snake eats food, and extends itself by
				// one

				eatenFood();
				// Method for moving trough panel
				for (int i = 0; i < snakes.size(); i++) {
					move(snakes.get(i).getSnakeX(), snakes.get(i).getSnakeY());
					checkCollision(snakes.get(i).getSnakeX(), snakes.get(i)
							.getSnakeY());
					repaint();
				}

				// Calling method that will check if snake hits where it
				// shouldn't.

			}
		});
		// Starting timer
		t.start();

		Socket client;
		try {

			client = new Socket("localhost", 5555);
			System.out.println("client connected");
			bw = new BufferedWriter(new OutputStreamWriter(
					client.getOutputStream()));
			ClientThread ct = new ClientThread(client);

			Thread t = new Thread(ct);
			t.start();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static class ClientThread implements Runnable {

		private Socket client;

		public ClientThread(Socket client) {
			this.client = client;
		}

		public void run() {
			try {

				ObjectInputStream reader = new ObjectInputStream(
						client.getInputStream());

				ObjectOutputStream writer = new ObjectOutputStream(
						client.getOutputStream());

				try {

					snakes = (ArrayList<Snake>) (reader.readObject());
					System.out.println(snakes);
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				}

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	/**
	 * This method will call paintComponent from super class, and draw objects
	 * from Draw method
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Draw(g);

	}

	/**
	 * This method will be used for drawing snake, food, and game panel
	 * 
	 * @param g
	 */
	public void drawSnake(Graphics g, int[] snakeX, int[] snakeY) {

		// Drawing snake
		for (int i = 0; i < size; i++) {
			// Representing snake head
			if (i == 0) {
				g.setColor(Color.BLACK);
				g.fillRect(snakeX[i], snakeY[i], TILESIZE, TILESIZE);
				g.setColor(Color.RED);
				g.fillRect(snakeX[i], snakeY[i], TILESIZE - 2, TILESIZE - 2);
				// Snake body
			} else {

				g.setColor(Color.BLACK);
				g.fillRect(snakeX[i], snakeY[i], TILESIZE, TILESIZE);
				g.setColor(Color.GREEN);
				g.fillRect(snakeX[i], snakeY[i], TILESIZE - 2, TILESIZE - 2);

				g.setColor(Color.RED);
				g.setFont(new Font("Serif", Font.BOLD, 15));
				g.drawString("Score: " + score, 10, 15);

			}

		}

	}

	private void Draw(Graphics g) {

		// Setting background color
		g.setColor(new Color(230, 230, 230));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		// Setting color for lines that are drawn every 10 spots
		g.setColor(Color.BLACK);
		// Drawing lines for field
		for (int i = 0; i < WIDTH / TILESIZE; i++) {

			g.drawLine(i * TILESIZE, 0, i * TILESIZE, HEIGHT);

		}
		for (int i = 0; i < HEIGHT / TILESIZE; i++) {

			g.drawLine(0, i * TILESIZE, WIDTH, i * TILESIZE);
		}
		// Drawing food on panel and setting color to red
		g.setColor(Color.RED);
		g.fillRect(foodX, foodY, TILESIZE, TILESIZE);
		// Drawing snake
		for (int i = 0; i < snakes.size(); i++) {
			drawSnake(g, snakes.get(i).getSnakeX(), snakes.get(i).getSnakeY());
		}

		// Synchronizes graphics state. It ensures that the display is
		// up-to-date
		Toolkit.getDefaultToolkit().sync();

	}

	/**
	 * Adding snake to list
	 * 
	 * @param s
	 *            - represents snake
	 */
	public void addSnake(Snake s) {
		snakes.add(s);
	}

	/**
	 * Method that generates food on random place in the gaming board
	 */
	private void generateFood() {
		int r = (int) (Math.random() * MAXFOODFIELD);
		foodX = ((r * TILESIZE));

		r = (int) (Math.random() * MAXFOODFIELD);
		foodY = ((r * TILESIZE));

	}

	/**
	 * This method is called when snake eats food. It is used to extend snake
	 * and generate new food on field
	 */
	private void eatenFood() {

		for (int i = 0; i < snakes.size(); i++) {
			if ((snakes.get(i).getSnakeX()[0] == foodX)
					&& (snakes.get(i).getSnakeY()[0] == foodY)) {
				gameSpeed++;
				size++;
				score += 10;
				generateFood();
				if (gameSpeed == 10) {
					t.setDelay(delay -= 1);
					gameSpeed = 0;
				}
			}
		}

	}

	/**
	 * This method simulates snake moving, and gives directions when clicking
	 * direction buttons.
	 */

	private void move(int[] snakeX, int[] snakeY) {

		try {

			for (int i = size; i > 0; i--) {
				snakeX[i] = snakeX[(i - 1)];
				snakeY[i] = snakeY[(i - 1)];

			}

			if (left) {

				snakeX[0] -= TILESIZE;
			}

			if (right) {

				snakeX[0] += TILESIZE;
			}

			if (up) {

				snakeY[0] -= TILESIZE;
			}

			if (down) {

				snakeY[0] += TILESIZE;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method checks if our snake hits into wall, or it hits her tail.
	 */
	private void checkCollision(int[] snakeX, int[] snakeY) {

		for (int i = size; i > 0; i--) {

			if ((i > 4) && (snakeX[0] == snakeX[i]) && (snakeY[0] == snakeY[i])
					|| snakeY[0] >= HEIGHT || snakeY[0] < 0
					|| snakeX[0] >= WIDTH || snakeX[0] < 0) {
				JOptionPane.showMessageDialog(null,
						"Game Over! Your final score is: " + score);

				System.exit(0);
			}
		}
	}

	/**
	 * This class is used as Key Listener, where we order snake where to go.
	 * 
	 * @author Mladen13
	 *
	 */
	// counter for setting pause
	private int counter = 0;

	private class KeyHandler extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {

			if ((e.getKeyCode() == KeyEvent.VK_LEFT) && (!right)) {
				left = true;
				up = false;
				down = false;
			}

			if ((e.getKeyCode() == KeyEvent.VK_RIGHT) && (!left)) {
				right = true;
				up = false;
				down = false;
			}

			if ((e.getKeyCode() == KeyEvent.VK_UP) && (!down)) {
				up = true;
				right = false;
				left = false;
			}

			if ((e.getKeyCode() == KeyEvent.VK_DOWN) && (!up)) {
				down = true;
				right = false;
				left = false;
			}

			// If space is pressed, game will be paused.
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				counter++;
				if (counter % 2 == 1) {
					getGraphics().drawString("PAUSE", 400, 300);
					t.stop();
				} else {
					t.start();
				}

			}
		}
	}
}
