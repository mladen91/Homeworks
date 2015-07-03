package ba.bitcamp.homework18.task07;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class is used to draw circle on spot where we click. After click we can
 * use slider to increase or decrease circle size.
 * 
 * @author Mladen13
 *
 */
public class Task7 extends JFrame {

	// Declaring variables
	private static final long serialVersionUID = 5688741915237317154L;
	private int x;
	private int y;
	private int r = 0;
	// Creating panel
	private JPanel panel = new myPanel();
	// Creating slider
	private JSlider circleSize = new JSlider(0, 5000, 0);

	public Task7() {
		// Setting frame layout
		setLayout(new BorderLayout());
		// Adding slider to panel
		panel.add(circleSize);
		// Adding change listener to slider
		circleSize.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				r = circleSize.getValue();
				repaint();

			}
		});
		// Adding panel
		add(panel);
		// Adding mouse listener to panel
		panel.addMouseListener(new Mouse());

		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * This class extends JPanel class. It is used to draw circle using Graphics
	 * class.
	 * 
	 * @author Mladen13
	 *
	 */
	private class myPanel extends JPanel {

		private static final long serialVersionUID = 7016820788756369373L;

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.drawOval(x - r / 2, y - r / 2, r, r);
			repaint();
		}

	}

	/**
	 * This class is used for getting x and y coordinates from circle.
	 * 
	 * @author Mladen13
	 *
	 */
	private class Mouse extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			x = e.getX();
			y = e.getY();
		}

	}

	public static void main(String[] args) {
		new Task7();

	}

}