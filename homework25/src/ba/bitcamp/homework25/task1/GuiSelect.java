package ba.bitcamp.homework25.task1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * This class simulates select command that gets us data from database showing
 * data into GUI
 * 
 * @author Mladen13
 *
 */
public class GuiSelect extends JFrame {

	private static final long serialVersionUID = 2705631766815091095L;

	private JButton insert = new JButton("Show data from database");
	private JTextArea complaintArea = new JTextArea();
	private Connection conn = null;

	/**
	 * Default constructor that adds gui component on frame
	 */
	public GuiSelect() {
		setLayout(new BorderLayout());
		add(insert, BorderLayout.SOUTH);
		add(complaintArea, BorderLayout.CENTER);
		insert.addActionListener(new ButtonHandler());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500, 250);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GuiSelect();
	}

	/**
	 * This class implements Action Listener and it is used for selecting data
	 * from database
	 * 
	 * @author Mladen13
	 *
	 */
	public class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager
						.getConnection("jdbc:sqlite:src/ba/bitcamp/homework25/databaseFiles/complaintsBook.db");
				System.out.println("Connection established");
			} catch (ClassNotFoundException e1) {
				System.err.println("JDBC library is not loaded.");
				System.err.println("Msg: " + e1.getMessage());
				System.exit(1);
			} catch (SQLException e1) {
				System.err.println("Could not connect to the database.");
				System.err.println("Msg: " + e1.getMessage());
				System.exit(1);

			}

			ArrayList<Complaint> list = new ArrayList<>();
			try {
				Statement statement = conn.createStatement();
				ResultSet result = statement
						.executeQuery("select * from complaints");

				while (result.next()) {
					int id = result.getInt(1);
					String timeDate = result.getString(2);
					String complaint = result.getString(3);

					Complaint c = new Complaint();
					c.setId(id);
					c.setTimeDate(timeDate);
					c.setText(complaint);
					list.add(c);
				}
			} catch (SQLException e1) {
				System.err.println("Bad SQL command.");
				System.err.println("Msg: " + e1.getMessage());
				System.exit(1);
			}

			complaintArea.setText(list.toString());

		}
	}
}
