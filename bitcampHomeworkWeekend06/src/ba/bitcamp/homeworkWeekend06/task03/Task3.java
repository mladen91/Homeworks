package ba.bitcamp.homeworkweekend06.task03;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class extends JFrame class. It contains constructor that will generate
 * grid layout 2 x 5. Through constructor 10 buttons will be added to layout
 * going from 0-9. After five clicks on button, program will display an array of
 * numbers we clicked.
 * 
 * @author Mladen13
 *
 */
public class Task3 extends JFrame {

	private static final long serialVersionUID = -2676334918269562622L;
	// Constant values for rows and columns
	public static final int ROWS = 2;
	public static final int COLUMNS = 5;
	// Creating array of buttons
	private JButton[] b1 = new JButton[ROWS * COLUMNS];
	private int counter = 0;
	// String that will be our displaying array
	private String[] arr = new String[5];

	public Task3() {
		// Setting grid layout 2 x 5
		setLayout(new GridLayout(ROWS, COLUMNS));
		// Creating button through loop
		for (int i = 0; i < b1.length; i++) {
			b1[i] = new JButton(String.valueOf(i));
			add(b1[i]);
			b1[i].addActionListener(new ButtonHandler());
		}
		// Setting visibility to true
		setVisible(true);
		// Setting size for frame 340 x 90
		setSize(340, 90);
		// Setting location for frame 400 x 350
		setLocation(400, 350);
		// Closing application
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// Calling constructor
		new Task3();

	}

	/**
	 * This class implements ActionListener class. It will check from which
	 * column our button is clicked. After checking, it will disable all column
	 * elements.
	 * 
	 * @author Mladen13
	 *
	 */
	public class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < arr.length; i++) {
				if (e.getSource() == b1[i] || e.getSource() == b1[i + COLUMNS]) {
					b1[i].setEnabled(false);
					b1[i + COLUMNS].setEnabled(false);
				}
			}

			((JButton) e.getSource()).setEnabled(false);

			arr[counter] = ((JButton) e.getSource()).getText();
			counter++;
			// When counter reaches five, application will display string
			if (counter == 5) {
				JOptionPane.showMessageDialog(null, Arrays.toString(arr));
				System.exit(EXIT_ON_CLOSE);
			}

		}

	}

}
