package ba.bitcamp.homeworkweekend06.task01;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class contains two constant attributes, array of buttons and String s.
 * It also contains constructor that will make grid layout 10 x 1, and using for
 * loop create buttons from 0 to 9.
 * 
 * @author Mladen13
 *
 */
public class Task1 extends JFrame {

	private static final long serialVersionUID = -3196311442843583418L;
	public static final int ROWS = 10;
	public static final int COLUMNS = 1;
	private int counter = 0;
	private JButton[] b1 = new JButton[ROWS];
	private String s = "";

	/**
	 * Creating constructor that creates buttons and sets grid layout
	 */
	public Task1() {
		// Setting new grid layout 10 x 1
		setLayout(new GridLayout(ROWS, COLUMNS));
		// For loop that generates 10 buttons from 0 to 9
		for (int i = 0; i < ROWS; i++) {
			b1[i] = new JButton("" + i);
			add(b1[i]);
			b1[i].addActionListener(new BH());
		}
		// Setting visibility to true
		setVisible(true);
		// Setting size for frame 300 x 300
		setSize(300, 300);
		// Setting location for frame 500 x 350
		setLocation(500, 350);
		// Closing application
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// Calling constructor
		new Task1();

	}

	/**
	 * This class implements interface ActionListener Action listener contains
	 * method called actionPerformed. After pushing a button setEnabled will be
	 * set to false, and that number will be set into String s When counter
	 * reaches 3, show message dialog appears, and it shows our number.
	 * 
	 * @author Mladen13
	 *
	 */
	public class BH implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// Setting clicked button enabled to false
			((JButton) e.getSource()).setEnabled(false);
			// Increasing counter by one, after every click
			counter++;
			// Putting numbers into string
			s += ((JButton) e.getSource()).getText();

			// Showing message dialog box when counter reaches 3
			if (counter == 3) {
				JOptionPane.showMessageDialog(null, "Number: " + s);
				System.exit(EXIT_ON_CLOSE);
			}

		}

	}

}
