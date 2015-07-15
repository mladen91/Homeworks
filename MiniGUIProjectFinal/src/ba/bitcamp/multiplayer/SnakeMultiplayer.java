package ba.bitcamp.multiplayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import ba.bitcamp.startgame.StartGame;

/**
 * This class is used for multiplayer snake game. It contains two snakes on
 * field, which goal is to get food as many as they can. Game system is based on
 * single player game methods, where difference is that every five moves, there
 * is extra food that gives 25 points.
 * 
 * @author Mladen13
 *
 */
public class SnakeMultiplayer extends JPanel {

	private static final long serialVersionUID = -9199685722803729431L;
	private static final int HEIGHT = 600;
	private static final int WIDTH = 800;
	private static final int MAXDOTS = 1000;
	private static final int DELAY = 50;
	private static final int MAXFOODFIELD = 59;
	private static final int TILESIZE = 10;
	// Snake arrays for X and Y coordinates
	private int[] snakeX = new int[MAXDOTS];
	private int[] snakeY = new int[MAXDOTS];

	private int[] snakeX2 = new int[MAXDOTS];
	private int[] snakeY2 = new int[MAXDOTS];

	// Snake size
	private int size;
	// Snake 2 size
	private int size2;
	// Food x and y coordinates
	private int foodX;
	private int foodY;
	// This variables will be used for changing directions
	private boolean left = false;
	private boolean right = true;
	private boolean up = false;
	private boolean down = false;

	// Changing directions for snake 2
	private boolean w = false;
	private boolean d = true;
	private boolean a = false;
	private boolean s = false;

	private int score = 0;
	// Snake 2 score
	private int score2 = 0;
	// Creating timer
	private int doubleScore = 0;
	private Timer t;

	/**
	 * In this constructor we create two snakes that we will use in game, and
	 * adding timer to application.
	 */
	public SnakeMultiplayer() {
		// Adding key listener that will move snake
		addKeyListener(new KeyHandler());
		setFocusable(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		gameInit();
		// Initializing timer with action listener
		t = new Timer(DELAY, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Calling method where snake eats food, and extends itself by
				// one

				eatedFood();
				// Method for moving trough panel
				move();
				// Moving snake 2
				move2();
				// Calling method that will check if snake hits where it
				// shouldn't.
				checkCollision();

				repaint();

			}
		});
		// Starting timer
		t.start();

	}

	/**
	 * This method initializes start of game
	 */
	public void gameInit() {
		// Setting snake size to 3
		size = 3;
		// Setting snake 2 size to 3
		size2 = 3;
		// This will make snake on the beginning of the game
		for (int i = 0; i < size; i++) {
			snakeX[i] = 50 - i * TILESIZE;
			snakeY[i] = 50;
		}
		// This will make snake 2
		for (int i = 0; i < size2; i++) {
			snakeX2[i] = 50 - i * TILESIZE;
			snakeY2[i] = 70;
		}
		// Calling method that will set food on random panel position
		generateFood();
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
		if (doubleScore == 4) {
			g.setColor(Color.MAGENTA);
			g.fillRect(foodX, foodY, TILESIZE, TILESIZE);
			StartGame.updateScore();
		} else {
			g.setColor(Color.RED);
			g.fillRect(foodX, foodY, TILESIZE, TILESIZE);
			StartGame.updateLabel();
		}

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
				g.setFont(new Font("Sans Serif", Font.BOLD, 15));
				g.drawString("Score: " + score, 10, 15);

			}
		}

		for (int i = 0; i < size2; i++) {
			// Representing snake 2 head
			if (i == 0) {
				g.setColor(Color.BLACK);
				g.fillRect(snakeX2[i], snakeY2[i], TILESIZE, TILESIZE);
				g.setColor(Color.BLUE);
				g.fillRect(snakeX2[i], snakeY2[i], TILESIZE - 2, TILESIZE - 2);
				// Snake 2 body
			} else {

				g.setColor(Color.BLACK);
				g.fillRect(snakeX2[i], snakeY2[i], TILESIZE, TILESIZE);
				g.setColor(Color.GREEN);
				g.fillRect(snakeX2[i], snakeY2[i], TILESIZE - 2, TILESIZE - 2);

				g.setColor(Color.BLUE);
				g.setFont(new Font("Sans Serif", Font.BOLD, 15));
				g.drawString("Score: " + score2, 725, 15);

			}
		}
		// Synchronizes graphics state. It ensures that the display is
		// up-to-date
		Toolkit.getDefaultToolkit().sync();

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
	private void eatedFood() {

		// If snake 1 eats food, it will be extended, and score will be
		// increased.Every fifth bite, score will be increased by 25.
		if ((snakeX[0] == foodX) && (snakeY[0] == foodY)) {
			doubleScore++;
			if (doubleScore == 5) {
				size++;
				score += 25;
				generateFood();
				doubleScore = 0;

			} else {
				size++;
				score += 10;
				generateFood();
			}

			// If snake 2 eats food, it will be extended, and score will be
			// increased. Every fifth bite, score will be increased by 25.
		} else if ((snakeX2[0] == foodX) && (snakeY2[0] == foodY)) {
			doubleScore++;
			if (doubleScore == 5) {
				size2++;
				score2 += 25;
				generateFood();
				doubleScore = 0;
			} else {
				size2++;
				score2 += 10;
				generateFood();
			}
		}
	}

	/**
	 * This method simulates snake moving, and gives directions when clicking
	 * direction buttons.
	 */
	private void move() {

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
	}

	/**
	 * This method simulates snake 2 moves, and it gives directions to snake
	 * when clicking w a s d buttons.
	 */
	private void move2() {

		for (int i = size2; i > 0; i--) {
			snakeX2[i] = snakeX2[(i - 1)];
			snakeY2[i] = snakeY2[(i - 1)];
		}

		if (a) {
			snakeX2[0] -= TILESIZE;
		}

		if (d) {
			snakeX2[0] += TILESIZE;
		}

		if (w) {
			snakeY2[0] -= TILESIZE;
		}

		if (s) {
			snakeY2[0] += TILESIZE;
		}
	}

	/**
	 * This method checks if our snake hits into wall, or it hits her tail.
	 */
	private void checkCollision() {
		int choiceP1Won;
		int choiceEven;
		int choiceP2Won;
		// Checking if snake hits itself
		for (int i = size; i > 0; i--) {

			if ((i > 4) && (snakeX[0] == snakeX[i]) && (snakeY[0] == snakeY[i])
					|| snakeY[0] >= HEIGHT || snakeY[0] < 0
					|| snakeX[0] >= WIDTH || snakeX[0] < 0) {
				// If snake hits itself, but score is larger than snake 2 score,
				// result will be even
				if (size > size2) {
					choiceEven = JOptionPane.showConfirmDialog(null,
							"Game Over! It's even! " + " \nPlayer 1 [" + score
									+ " : " + score2 + "] 2 Player"
									+ "\nDo you want to play again?");

					if (choiceEven == JOptionPane.YES_OPTION) {
						gameInit();
					} else if (choiceEven == JOptionPane.NO_OPTION) {
						System.exit(0);
					}
				} else {
					// In this case, player 2 won.
					choiceP2Won = JOptionPane.showConfirmDialog(null,
							"Game Over! Player 2 won! " + " \nPlayer 1 ["
									+ score + " : " + score2 + "] 2 Player"
									+ "\nDo you want to play again?");
					if (choiceP2Won == JOptionPane.YES_OPTION) {
						gameInit();
					} else if (choiceP2Won == JOptionPane.NO_OPTION) {
						System.exit(0);
					}
				}

			}
		}
		// Checking if snake 2 hits itself
		for (int i = size2; i > 0; i--) {

			if ((i > 4) && (snakeX2[0] == snakeX2[i])
					&& (snakeY2[0] == snakeY2[i]) || snakeY2[0] >= HEIGHT
					|| snakeY2[0] < 0 || snakeX2[0] >= WIDTH || snakeX2[0] < 0) {
				// If snake hits itself, but score is larger than snake 1 score,
				// result will be even
				if (size2 > size) {
					choiceEven = JOptionPane.showConfirmDialog(null,
							"Game Over! It's even! " + " \nPlayer 1 [" + score
									+ " : " + score2 + "] 2 Player"
									+ "\nDo you want to play again?");
					if (choiceEven == JOptionPane.YES_OPTION) {
						gameInit();
					} else if (choiceEven == JOptionPane.NO_OPTION) {
						System.exit(0);
					}

				} else {
					choiceP1Won = JOptionPane.showConfirmDialog(null,
							"Game Over! Player 1 won! " + " \nPlayer 1 ["
									+ score + " : " + score2 + "] 2 Player"
									+ "\nDo you want to play again?");
					if (choiceP1Won == JOptionPane.YES_OPTION) {
						gameInit();
					} else if (choiceP1Won == JOptionPane.NO_OPTION) {
						System.exit(0);
					}
				}
			}
		}
		// If snakes hits each other head, score will decide the result
		for (int i = 0; i < size; i++) {
			if (snakeX[0] == snakeX2[0] && snakeY[0] == snakeY2[0]) {
				if (size > size2) {
					choiceP1Won = JOptionPane.showConfirmDialog(null,
							"Game Over! Player 1 won! " + " \nPlayer 1 ["
									+ score + " : " + score2 + "] 2 Player"
									+ "\nDo you want to play again?");
					if (choiceP1Won == JOptionPane.YES_OPTION) {
						gameInit();
					} else if (choiceP1Won == JOptionPane.NO_OPTION) {
						System.exit(0);
					}
				} else if (size < size2) {
					// In this case, player 2 won.
					choiceP2Won = JOptionPane.showConfirmDialog(null,
							"Game Over! Player 2 won! " + " \nPlayer 1 ["
									+ score + " : " + score2 + "] 2 Player"
									+ "\nDo you want to play again?");
					if (choiceP2Won == JOptionPane.YES_OPTION) {
						gameInit();
					} else if (choiceP2Won == JOptionPane.NO_OPTION) {
						System.exit(0);
					}
				} else {
					choiceEven = JOptionPane.showConfirmDialog(null,
							"Game Over! It's even! " + " \nPlayer 1 [" + score
									+ " : " + score2 + "] 2 Player"
									+ "\nDo you want to play again?");
					if (choiceEven == JOptionPane.YES_OPTION) {
						gameInit();
					} else if (choiceEven == JOptionPane.NO_OPTION) {
						System.exit(0);
					}
				}
			}
		}

	}

	/**
	 * This class is used as Key Listener, where we order snake where to go.
	 * 
	 * @author Mladen13
	 *
	 */
	int counter = 0;

	private class KeyHandler extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {

			// key buttons for snake 1
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

			// Key buttons for snake 2
			if ((e.getKeyCode() == KeyEvent.VK_A) && (!d)) {
				a = true;
				w = false;
				s = false;
			}

			if ((e.getKeyCode() == KeyEvent.VK_D) && (!a)) {
				d = true;
				w = false;
				s = false;
			}

			if ((e.getKeyCode() == KeyEvent.VK_W) && (!s)) {
				w = true;
				d = false;
				a = false;
			}

			if ((e.getKeyCode() == KeyEvent.VK_S) && (!w)) {
				s = true;
				d = false;
				a = false;
			}
			// If key space is pressed, game will be paused
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
