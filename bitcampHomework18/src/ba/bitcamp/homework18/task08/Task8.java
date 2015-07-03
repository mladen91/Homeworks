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
				if (e.getSource() == clearButton) {
					userName.setText("");
					userPass1.setText("");
					userPass2.setText("");
				}

			}
		});
		p.add(submitButton);
		// Adding action listener that will check if inserted username and
		// password are correct.
		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String correctUserName = "Mujo123";
				String correctPassword = "1234567";
				String givenUserName = userName.getText();
				String givenPassword = String.valueOf(userPass1.getPassword());
				String givenConfirmPassword = String.valueOf(userPass2
						.getPassword());

				if (e.getSource() == submitButton) {
					if (correctUserName.equals(givenUserName)
							&& correctPassword.equals(givenPassword)
							&& correctPassword.equals(givenConfirmPassword)) {

						JOptionPane.showMessageDialog(null,
								"Registration was successful");
					} else if (givenUserName.length() < 6) {
						JOptionPane.showMessageDialog(null,
								"Username must contain at least 6 characters.");
					} else if (givenPassword.length() < 6) {
						JOptionPane.showMessageDialog(null,
								"Password must contain at least 6 characters.");
					} else if (!correctPassword.equals(givenPassword)
							|| !correctPassword.equals(givenConfirmPassword)) {
						JOptionPane.showMessageDialog(null,
								"Inserted passwords are different.");
					}

				}

			}
		});

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Task8();

	}

}
