package ba.bitcamp.homeworkWeekend06.task04;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task4 extends JFrame {

	private static final long serialVersionUID = 6421386269643812285L;

	private String s = "";
	private int counter = 0;
	// Creating buttons
	private JButton bN = new JButton("Char: " + randomLetter());
	private JButton bS = new JButton("Insert");
	private JButton bE = new JButton(">");
	private JButton bW = new JButton("<");
	// Creating labels
	private JLabel l1 = new JLabel("_");
	private JLabel l2 = new JLabel();

	/**
	 * Constructor that contains 4 button and 2 layers that are added to frame.
	 * It also contains setters for location visibility and size
	 */
	public Task4() {
		// Adding button on top of the frame
		add(bN, BorderLayout.NORTH);
		bN.addActionListener(new BH());
		// Adding button on the bottom of the frame
		add(bS, BorderLayout.SOUTH);
		bS.addActionListener(new BH());
		// Adding button to the right side
		add(bE, BorderLayout.EAST);
		bE.addActionListener(new BH());
		// Adding button to the left side
		add(bW, BorderLayout.WEST);
		bW.addActionListener(new BH());
		// Adding labels
		add(l1);
		// Adding second empty label just enable moving of first one
		add(l2);
		l1.setBounds(149, 55, 150, 50);

		// Setting visibility to true
		setVisible(true);
		// Setting size for frame 340 x 200
		setSize(340, 200);
		// Setting location for frame 400 x 350
		setLocation(400, 350);
		// Closing application
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// Calling constructor
		new Task4();
	}

	/**
	 * This class implements ActionListener interface. We added actions to our
	 * four buttons here, and proceeded them to constructor from main class
	 * 
	 * @author Mladen13
	 *
	 */
	public class BH implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// Clicking button "Insert"
			if (e.getSource() == bS) {
				// Inserting random button in the end of String
				if (counter == s.length() - 1) {
					l1.setText(s.substring(0, counter)
							+ s.substring(counter, s.length())
							+ bN.getText().substring(bN.getText().length() - 1));
					s = l1.getText();
					// Inserting random button on the beginning or somewhere in
					// string
				} else {
					l1.setText(s.substring(0, counter)
							+ bN.getText().substring(bN.getText().length() - 1)
							+ s.substring(counter, s.length()));
					s = l1.getText();
				}

			}
			// Clicking on this button will generate random character and set it
			// on top
			if (e.getSource() == bN) {
				bN.setText("Char: " + randomLetter());
			}
			// Clicking this button will move our _ to the right side
			if (e.getSource() == bE) {
				if (counter < s.length() - 1) {
					l1.setText(getText(++counter));
				}
			}
			// Clicking this button will move _ to left side
			if (e.getSource() == bW) {
				if (counter > 0) {
					l1.setText(getText(--counter));
				}
			}
		}
	}

	/**
	 * This method contains Random letter generator. ASCII code is being used to
	 * get letters from A to Z.
	 *
	 * @return new String s
	 */

	public char randomLetter() {

		Random rnd = new Random();

		char c = (char) (rnd.nextInt(25) + 65);

		return c;

	}

	/**
	 * This method will make character array using String s, and insert char '_'
	 * into it.
	 * 
	 * @param index
	 *            - represents spot where '_' will be seated
	 * @return - new String s with '_'
	 */
	public String getText(int index) {
		char[] c = new char[s.length()];
		String str = "";
		for (int i = 0; i < c.length; i++) {
			if (i == index) {
				c[i] = '_';
			} else {
				c[i] = s.charAt(i);
			}
		}
		for (int i = 0; i < c.length; i++) {
			str += c[i];
		}
		return str;
	}

}
