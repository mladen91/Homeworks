package ba.bitcamp.homework18.task01;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class extends JFrame class. It contains one label and one slider. Main
 * use of this class is to click on slider, and increase or decrease Font.
 * 
 * @author Mladen13
 *
 */
public class Task1 extends JFrame {
	private static final long serialVersionUID = -1965620838762557602L;
	// Making JSlider
	private JSlider s1 = new JSlider(0, 100);
	// Making JLabel
	private JLabel l1 = new JLabel("Mladen");
	private Font f1;

	public Task1() {
		// Adding label on frame
		add(l1);
		// Setting label position
		l1.setBounds(getHeight() / 2, 250, 400, 100);
		// Adding slider on frame
		add(s1);
		s1.setMinorTickSpacing(10);
		s1.setMajorTickSpacing(50);
		s1.setPaintTicks(true);
		// Adding change listener to slider
		s1.addChangeListener(new CL());

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Task1();

	}

	/**
	 * This class implements ChangeListener interface. It will change font when
	 * we are using Slider.
	 * 
	 * @author Mladen13
	 *
	 */
	public class CL implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {

			f1 = new Font("Serif", Font.PLAIN, s1.getValue());
			l1.setFont(f1);

		}

	}

}
