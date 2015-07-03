package ba.bitcamp.homework18.task09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class is used to read informations from file.
 * 
 * @author Mladen13
 *
 */
public class Task9 extends JFrame {

	private static final long serialVersionUID = -6401412281292116732L;
	//Creating panel
	private JPanel panel = new JPanel();
	//Creating text field
	private JTextField field = new JTextField();
	//Creating text area
	private JTextArea area = new JTextArea();

	public static void main(String[] args) {
		new Task9();
	}

	public Task9() {
		//adding panel to frame
		add(panel);
		//setting panel layout 
		panel.setLayout(new BorderLayout());
		//Giving field and area coordinates
		panel.add(field, BorderLayout.NORTH);
		panel.add(area, BorderLayout.CENTER);
		//Setting field and area background
		field.setBackground(new Color(212, 36, 45));
		area.setBackground(new Color(165, 217, 152));
		//adding action listener
		field.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					TextIO.readFile(field.getText());
					String s = "";
					while (!TextIO.eof()) {
						s += TextIO.getln() + "\n";
					}
					area.setText(s);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Can't find given file", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});

		setSize(400, 300);
		setLocationRelativeTo(null);
		setTitle("Task1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
