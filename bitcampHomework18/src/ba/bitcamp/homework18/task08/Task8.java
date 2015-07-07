package ba.bitcamp.homework18.task08;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Task8 extends JFrame {
	private static final long serialVersionUID = 2805776665098362430L;
	// Creating text field
	private JTextField userName = new JTextField();
	// Creating password fields
	private JPasswordField userPass1 = new JPasswordField();
	private JPasswordField userPass2 = new JPasswordField();
	// Creating buttons
	private JButton submitButton = new JButton("Submit");
	private JButton clearButton = new JButton("Clear");

	// Creating labels
	JLabel userNameLabel = new JLabel("Username: ");
	JLabel passwordLabel = new JLabel("Password: ");
	JLabel confirmPasswordLabel = new JLabel("Confirm your password: ");

	// Creating panel
	JPanel p = new JPanel();

	public Task8() {
		// Adding panel to frame
		add(p);
		// Setting panel layout
		p.setLayout(new GridLayout(4, 2));
		// Adding elements to panel
		p.add(userNameLabel);
		p.add(userName);

		p.add(passwordLabel);
		p.add(userPass1);

		p.add(confirmPasswordLabel);
		p.add(userPass2);

		p.add(clearButton);
		// Adding action listener to clear button
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				userName.setText("");
				userPass1.setText("");
				userPass2.setText("");

			}
		});
		p.add(submitButton);
		// Adding action listener that will check if inserted username and
		// password are correct.
		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (userName.getText().length() < 6) {
					JOptionPane.showMessageDialog(null,
							"Username must have at least 6 characters");
				} else if (!String.valueOf(userPass1.getPassword()).equals(
						String.valueOf(userPass2.getPassword()))) {
					JOptionPane.showMessageDialog(null,
							"Passwords do not match");
				} else if (userPass1.getPassword().length < 6) {
					JOptionPane.showMessageDialog(null,
							"Password must have at least 6 characters");
				} else if (!hasDigitAndCharacter(userPass1.getPassword())) {
					JOptionPane
							.showMessageDialog(null,
									"Password must contain at least one digit and one special character\n(@ # ^ %)");

				} else {
					setVisible(false);
					JOptionPane.showMessageDialog(null,
							"Form is succesfully filled");
					System.exit(0);
					;
				}

			}

			private boolean hasDigitAndCharacter(char[] password) {
				for (int i = 0; i < password.length; i++) {
					if (password[i] >= 48 && password[i] <= 57) {
						for (int j = 0; j < password.length; j++) {
							if ((password[j] >= 33 && password[j] <= 46)
									|| (password[j] >= 58 && password[j] <= 64)) {
								return true;
							}
						}
					}
				}
				return false;
			}
		});

		setSize(350, 150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Task8();

	}

}
