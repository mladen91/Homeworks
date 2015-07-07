package ba.bitcamp.homework18.task03;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * This class extends JFrame. It simulates user login to some page using text
 * field and password field
 * 
 * @author Mladen13
 *
 */
public class Task3 extends JFrame {
	private static final long serialVersionUID = 6192260289998813422L;

	// Creating text field
	private JTextField text = new JTextField();
	// Creating password field
	private JPasswordField pass = new JPasswordField();
	// Creating labels
	private JLabel l1 = new JLabel("Username:");
	private JLabel l2 = new JLabel("Password:");

	private static final String correctUsername = "Mujo";
	private static final String correctPassword = "1234";

	public Task3() {
		// Setting grid layout 2 x 2 to frame
		setLayout(new GridLayout(2, 2));
		// Adding labels and text fields
		add(l1);
		add(text);
		add(l2);
		add(pass);
		// Adding action listeners
		text.addActionListener(new passwordHandler());
		pass.addActionListener(new passwordHandler());
		setSize(300, 100);

		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Task3();

	}

	/**
	 * This class checks if user name and password are correct.
	 * 
	 * @author Mladen13
	 *
	 */
	public class passwordHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String givenUsername = text.getText();

			String givenPassword = String.valueOf(pass.getPassword());

			if (correctPassword.equals(givenPassword)
					&& correctUsername.equals(givenUsername)) {
				System.exit(0);
			} else {
				JOptionPane.showMessageDialog(null,
						"Incorrect username or password!");
			}

		}

	}

}
