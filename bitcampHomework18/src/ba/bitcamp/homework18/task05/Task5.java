package ba.bitcamp.homework18.task05;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class is used to change background of panel, using three sliders.
 * 
 * @author Mladen13
 *
 */
public class Task5 extends JPanel {

	private static final long serialVersionUID = 7715737420901333515L;

	private int red;
	private int green;
	private int blue;

	private JLabel redLabel = new JLabel("Red");
	private JLabel greenLabel = new JLabel("Green");
	private JLabel blueLabel = new JLabel("Blue");

	public Task5(int width, int height) {
		// setting layout to panel
		setLayout(new GridLayout(3, 2));
		// declaring slider height
		int sliderHeight = (height / 7);
		// Creating slider dimension
		Dimension sliderDimension = new Dimension(width - 50, sliderHeight);
		// Creating sliders
		JSlider redSlider = new JSlider(0, 255);
		initSlider(redSlider, "Red", sliderDimension);

		JSlider greenSlider = new JSlider(0, 255);
		initSlider(greenSlider, "Green", sliderDimension);

		JSlider blueSlider = new JSlider(0, 255);
		initSlider(blueSlider, "Blue", sliderDimension);
		// Creating labels

		// Adding labels
		add(redLabel);
		add(redSlider);

		add(greenLabel);
		add(greenSlider);

		add(blueLabel);
		add(blueSlider);

	}

	/**
	 * Method that adjusts slider dimensions, name, tick spacing..
	 * 
	 * @param slider
	 *            - represents our sliders
	 * @param name
	 *            - name of slider
	 * @param d
	 *            - slider dimensions
	 */
	private void initSlider(JSlider slider, String name, Dimension d) {
		slider.setName(name);
		slider.setPreferredSize(d);
		slider.setValue(0);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(25);
		slider.setPaintTicks(true);
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider changed = (JSlider) e.getSource();

				String name = changed.getName();
				switch (name) {
				case "Red":
					red = changed.getValue();
					break;
				case "Green":
					green = changed.getValue();
					break;
				case "Blue":
					blue = changed.getValue();
					break;
				}
				updateBackground();

			}
		});

	}

	/**
	 * Method that updates panel background and text foreground
	 */
	private void updateBackground() {
		setBackground(new Color(red, green, blue));
		redLabel.setForeground(new Color(255 - red, 255 - green, 255 - blue));
		greenLabel.setForeground(new Color(255 - red, 255 - green, 255 - blue));
		blueLabel.setForeground(new Color(255 - red, 255 - green, 255 - blue));

	}

	public static void main(String[] args) {
		// Creating window
		JFrame window = new JFrame("Picker");
		// Creating panel and adding it to window
		Task5 cp = new Task5(500, 500);
		window.add(cp);

		window.setSize(500, 500);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
