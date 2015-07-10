package ba.bitcamp.homework18.task02;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class will be used to change font to bold, italic or both.
 * 
 * @author Mladen13
 *
 */
public class Task2 extends JFrame {
	private static final long serialVersionUID = -5695010826702907061L;
	// Creating label
	private JLabel label = new JLabel("Mladen");
	// Creating check boxes
	private JCheckBox cb1 = new JCheckBox("Bolded");
	private JCheckBox cb2 = new JCheckBox("Italic");
	// Creating button
	private JButton b1 = new JButton("Refresh");
	private Font f1;
	private JPanel p = new JPanel();

	public Task2() {

		// Adding panel on frame
		add(p);
		// Setting panel border
		p.setBorder(BorderFactory.createTitledBorder("Change font"));
		// Setting panel layout
		p.setLayout(new GridLayout(3, 1));
		// adding label on panel
		p.add(label);
		// Adding check boxes on panel
		p.add(cb1);
		p.add(cb2);
		// Adding button on panel
		p.add(b1);
		b1.addActionListener(new RefreshActionListener());

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Task2();

	}

	/**
	 * This class implements ActionListener interface. It will check conditions
	 * for check boxes, and change font style if needed.
	 * 
	 * @author Mladen13
	 *
	 */
	public class RefreshActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (cb1.isSelected() && cb2.isSelected()) {
				f1 = new Font("Serif", Font.ITALIC | Font.BOLD, 20);
				label.setFont(f1);
			} else if (cb1.isSelected()) {
				f1 = new Font("Serif", Font.BOLD, 20);
				label.setFont(f1);
			} else if (cb2.isSelected() == true) {
				f1 = new Font("Serif", Font.ITALIC, 20);
				label.setFont(f1);
			} else {
				f1 = new Font("Serif", Font.PLAIN, 20);
				label.setFont(f1);
			}

		}

	}

}
