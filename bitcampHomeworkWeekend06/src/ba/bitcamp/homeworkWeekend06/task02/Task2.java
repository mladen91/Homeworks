package ba.bitcamp.homeworkweekend06.task02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class extends JFrame class. It contains two inner classes that generate
 * names randomly. It also contains BH class that implements ActionListener
 * interface where we connected buttons and added actions to them.
 * 
 * @author Mladen13
 *
 */
public class Task2 extends JFrame {

	private static final long serialVersionUID = 1039602972199556972L;
	// Creating button with First Name text on it
	private JButton b1 = new JButton("First Name");
	// Creating button with Last Name on it
	private JButton b2 = new JButton("Last Name");
	// Creating labels for first name, last name
	private JLabel l1;
	private JLabel l2;
	// Creating empty label because without it i couldn't move l2 through
	// window(frame)
	private JLabel l3 = new JLabel();
	// Creating object ng from inner class NameGenerator
	NameGenerator ng = new NameGenerator();
	// Creating object lng from inner class LastNameGenerator
	LastNameGenerator lng = new LastNameGenerator();

	/**
	 * Creating constructor that will create labels, buttons, and frame.
	 */
	public Task2() {

		// Initializing l1 label with value from inner class NameGenerator
		l1 = new JLabel(ng.generateName());
		// Initializing l2 label with value from inner class LastNameGenerator
		l2 = new JLabel(lng.generateName());
		// Adding label 1 to window
		add(l1);
		// Setting coordinates to label 1
		l1.setBounds(170, 60, 100, 20);
		// Adding label 2 to window
		add(l2);
		// Setting coordinates to label 2
		l2.setBounds(215, 60, 100, 20);
		// Adding empty label
		add(l3);
		// Adding button "First Name" to window
		add(b1, BorderLayout.WEST);
		// Adding ActionListener to button1
		b1.addActionListener(new BH());
		// Adding button "Last Name" to window
		add(b2, BorderLayout.EAST);
		// Adding ActionListener to button2
		b2.addActionListener(new BH());
		// Setting visibility to true
		setVisible(true);
		// Setting size for frame 450 x 180
		setSize(450, 180);
		// Setting location for frame 400 x 350
		setLocation(400, 350);
		// Closing application
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * This class contains array of names, generateName and toString method.
	 * GenerateName method will randomly return one name from array string.
	 * toString will only print that name.
	 * 
	 * @author Mladen13
	 *
	 */
	public static class NameGenerator {

		String[] names = { "Mladen", "Gordan", "Adis", "Edvin", "Zeljko",
				"Ajla", "Hajrudin" };

		/**
		 * This method will generate name from array using Random(), that will
		 * randomly generate one index from array and after that pass that value
		 * into array, and get one name that will be returned.
		 * 
		 * @return - randomly generated name
		 */
		public String generateName() {
			int idx = new Random().nextInt(names.length);
			String random = (names[idx]);

			return random;
		}

		/**
		 * Printing random name
		 */
		public String toString() {
			return "First name: " + generateName();
		}

	}

	/**
	 * This class contains array of Last Names, generateName and toString
	 * method. GenerateName method will randomly return one last name from array
	 * string. toString will only print that last name.
	 * 
	 * @author Mladen13
	 *
	 */
	public static class LastNameGenerator {
		String[] lastNames = { "Teofilovic", "Masic", "Cehajic", "Mulabdic",
				"Miljevic", "El Tabari", "Sehic" };

		/**
		 * This method will generate Last Name from array using Random(), that
		 * will randomly generate one index from array and after that pass that
		 * value into array, and get one last name that will be returned.
		 * 
		 * @return - randomly generated name
		 */
		public String generateName() {
			int idx = new Random().nextInt(lastNames.length);
			String random = (lastNames[idx]);

			return random;
		}

		public String toString() {
			return "Last name: " + generateName();
		}
	}

	/**
	 * This class connects buttons with setting randomly names and last names to
	 * label.
	 * 
	 * @author Mladen13
	 *
	 */
	public class BH implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Creating first and last name generator
			NameGenerator ng = new NameGenerator();
			LastNameGenerator lng = new LastNameGenerator();

			if (e.getSource() == b1) {
				l1.setText(ng.generateName());
			} else if (e.getSource() == b2) {
				l2.setText(lng.generateName());
			}

		}

	}

	public static void main(String[] args) {
		// Calling constructor
		new Task2();

	}

}
