package ba.bitcamp.homework18.task06;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * This class extends JFrame class. It is used for counting from our number to 0
 * when button start is clicked.
 * 
 * @author Mladen13
 *
 */
public class Task6 extends JFrame {

	private static final long serialVersionUID = -8026123167804945558L;
	// Creating label
	private JLabel l = new JLabel("Text");
	// Creating text field
	private JTextField text = new JTextField();
	// Creating button
	private JButton b = new JButton("Start");
	// Creating timer
	private Timer t;
	private int num = 0;

	public Task6() {
		// Initializing timer that ticks every second
		t = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (num >= 0) {
					l.setText("" + num--);
				} else {
					t.stop();
					text.setText("");
				}
			}
		});
		// Setting layout
		setLayout(new GridLayout(3, 1));
		// Adding label
		add(l);
		l.setHorizontalAlignment(l.CENTER);
		// Adding text field
		add(text);
		text.setHorizontalAlignment(text.CENTER);
		// Adding button
		add(b);
        //adding action listener to button
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					if (e.getSource() == b) {
						t.start();
						num = Integer.parseInt(text.getText());
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Wrong format inserted!");
				}

			}
		});

		setSize(300, 100);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new Task6();

	}
}
