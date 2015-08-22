package ba.bitcamp.homework25.task1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * This class simulates insertion data into database using GUI.
 * 
 * @author Mladen13
 *
 */
public class GuiInsert extends JFrame {

	private static final long serialVersionUID = 2705631766815091095L;

	private JButton insert = new JButton("Insert");
	private JTextArea complaintArea = new JTextArea();
	private Connection conn = null;

	/**
	 * Default GUI constructor that is used for showing components on JFrame
	 */
	public GuiInsert() {
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
		new GuiInsert();
	}

	/**
	 * This class implements action listener and it is used for inserting data
	 * to database when button insert is clicked
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
						.getConnection("jdbc:sqlite:C:/Users/Mladen13/Desktop/database/complaintsBook.db");
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

			try {
				Complaint c = new Complaint();
				Statement statement = conn.createStatement();
				// Prikaz kreirane tabele (komanda pokrenuta samo prvi put)
				// String createTableCommand =
				// "CREATE TABLE complaints (id integer primary key, time_date varchar(40), text varchar(255))";
				// statement.executeUpdate(createTableCommand);

				c.setTimeDate(DateTime.timeDate());
				String insertCommand = "INSERT INTO complaints (time_date, text) VALUES('"
						+ c.getTimeDate()
						+ "', '"
						+ complaintArea.getText()
						+ "')";
				statement.executeUpdate(insertCommand);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}

