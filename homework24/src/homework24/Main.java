package homework24;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame {

	private static final long serialVersionUID = 5404827922497573885L;

	private JPanel p = new JPanel();

	private static JLabel l2 = new JLabel("Eat as many as you can!");

	public Main() {
		GamePanel panel = new GamePanel();
        //Adding snake to panel
		panel.addSnake(new Snake());

		setLayout(new BorderLayout());
		add(p, BorderLayout.NORTH);
		p.add(l2);
		add(panel);

		setResizable(false);
		pack();

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		JFrame ex = new Main();
		ex.setVisible(true);
	}
}
