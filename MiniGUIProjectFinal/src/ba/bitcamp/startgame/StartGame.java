package ba.bitcamp.startgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ba.bitcamp.dialog.MyDialog;
import ba.bitcamp.multiplayer.SnakeMultiplayer;
import ba.bitcamp.singleplayer.Snake;

/**
 * This class extends JFrame class, and it is used for starting our game. We can
 * choose between Single Player and Multiplayer modes. When we start game, there
 * is menu where we can choose what will we play.
 * 
 * @author Mladen13
 *
 */
public class StartGame extends JFrame {

	private static final long serialVersionUID = -4771609170448976958L;

	private JPanel p = new JPanel();
	private static JLabel l = new JLabel();
	private static JLabel l2 = new JLabel("Eat as many as you can!");
	// Creating object from class MyDialog
	private MyDialog md = new MyDialog();

	/**
	 * This constructor is used for creating our game. When we choose between
	 * multiplayer and single player modes, constructor will set values to true
	 * or false when needed.
	 */
	public StartGame() {

		// Creating multiplayer mode
		if (md.isSinglePlayer()) {
			Snake s = new Snake();
			setLayout(new BorderLayout());
			add(p, BorderLayout.NORTH);
			p.add(l2);
			add(s);
			setResizable(false);
			pack();
			setTitle("Snake - Multiplayer Mode");

		} else if (md.isMultiPlayer()) {
			SnakeMultiplayer s1 = new SnakeMultiplayer();
			setLayout(new BorderLayout());
			add(p, BorderLayout.NORTH);
			p.add(l);
			l.setFont(new Font("Sans Serif", Font.BOLD, 12));
			l.setForeground(Color.RED);
			p.add(l2);
			add(s1);
			setResizable(false);
			pack();
			setTitle("Snake - Single Player Mode");
			// Creating single player mode
		}
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Method that will remind players that food is worthy 25 points
	 */
	public static void updateScore() {
		l.setText("Double score time! Double score time! Double score time!");
		l2.setText("");
	}

	/**
	 * Method that will remind players that food is worthy 10 points
	 */
	public static void updateLabel() {
		l.setText("");
		l2.setText("Normal eat time!");
	}

	public static void main(String[] args) {

		JFrame ex = new StartGame();
		ex.setVisible(true);

	}

}
