package ba.bitcamp.dialog;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ba.bitcamp.highscore.TextIO;

/**
 * This class is used as start menu for snake game.. There are 4 buttons that
 * represent Single Player mode, Multiplayer mode, Highscore and Exit
 * Application.
 * 
 * @author Mladen13
 *
 */
public class MyDialog extends JDialog {
	private static final long serialVersionUID = -4070623060379881616L;

	private JPanel labelPanel = new JPanel();
	private JLabel backgroundLabel = new JLabel();
	private JPanel buttonPanel = new JPanel();
	private JButton singlePlayer = new JButton("Single Player");
	private JButton multiPlayer = new JButton("Multiplayer");
	private JButton exit = new JButton("Exit Application");
	private JButton highScore = new JButton("Highscore");
	private boolean isSinglePlayer = true;
	private boolean isMultiPlayer = true;

	/**
	 * We are sending this getter to main class where we decide which game mode
	 * we play
	 * 
	 * @return true if we want to play single player, else false
	 */
	public boolean isSinglePlayer() {
		return isSinglePlayer;
	}

	/**
	 * We are sending this getter to main class where we decide which game mode
	 * we play
	 * 
	 * @return true if we want to play multiplayer, else false
	 */
	public boolean isMultiPlayer() {
		return isMultiPlayer;
	}

	/**
	 * This constructor is used for creating buttons, panels, and insert picture
	 * of snake as background.
	 */
	public MyDialog() {

		setLayout(new GridLayout(2, 1));
		add(labelPanel);
		labelPanel.add(backgroundLabel);
		backgroundLabel.setIcon(new ImageIcon(
				"src/ba/bitcamp/startgame/snake1.png"));

		add(buttonPanel);

		buttonPanel.setLayout(new GridLayout(4, 1));
		buttonPanel.add(singlePlayer);
		buttonPanel.add(multiPlayer);
		buttonPanel.add(highScore);
		buttonPanel.add(exit);

		singlePlayer.addActionListener(new ButtonHandler());
		multiPlayer.addActionListener(new ButtonHandler());
		highScore.addActionListener(new ButtonHandler());
		exit.addActionListener(new ButtonHandler());
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(200, 300);
		setLocationRelativeTo(null);
		setTitle("Game Menu");
		setVisible(true);
	}

	/**
	 * Class that implements Action Listener and it is used to handle our clicks
	 * on buttons
	 * 
	 * @author Mladen13
	 *
	 */
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == singlePlayer) {
				isMultiPlayer = false;
				dispose();

			} else if (e.getSource() == multiPlayer) {
				isSinglePlayer = false;
				dispose();

			} else if (e.getSource() == exit) {
				System.exit(0);
			} else if (e.getSource() == highScore) {

				new HighScoreDialog();
				dispose();
			}

		}

	}

	/**
	 * Class that extends JDialog, and when we click on highscore from
	 * MyDialog(), opens new dialog where we can see game highscore
	 * 
	 * @author Mladen13
	 *
	 */
	private class HighScoreDialog extends JDialog {
		private static final long serialVersionUID = -4070623060379881616L;

		private JLabel l = new JLabel();
		private JButton backButton = new JButton("Back");

		/**
		 * This constructor is used for creating high score dialog, where we can
		 * find back button, to main menu.
		 */
		public HighScoreDialog() {
			setLayout(new BorderLayout());
			add(l, BorderLayout.CENTER);
			add(backButton, BorderLayout.SOUTH);
			backButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					new MyDialog();
					dispose();

				}
			});
			// Reading from file, and setting text to that value because it
			// represents highscore
			TextIO.readFile("src/ba/bitcamp/highscore/highscore");
			l.setText("Snake Highscore: " + TextIO.getln());
			l.setHorizontalAlignment(SwingConstants.CENTER);
			setModalityType(ModalityType.APPLICATION_MODAL);
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setSize(200, 100);
			setLocationRelativeTo(null);
			setTitle("Game Highscore");
			setVisible(true);
		}
	}
}
