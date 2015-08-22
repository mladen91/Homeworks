package ba.bitcamp.homework25.task3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

import ba.bitcamp.homework25.task2.Product;

/**
 * this class simulates deletion data from database usig GUI
 * 
 * @author Mladen13
 *
 */
public class GuiDelete extends JFrame {

	private static final long serialVersionUID = 2709871593389178999L;

	private JList<String> list = new JList<>();
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JButton delete = new JButton("Delete");
	private Connection conn = null;
	private ArrayList<String> codeList = new ArrayList<String>();

	/**
	 * Default constructor that adds components to field
	 */
	public GuiDelete() {
		setLayout(new BorderLayout());
		add(list, BorderLayout.CENTER);
		add(delete, BorderLayout.SOUTH);
		delete.addActionListener(new ButtonHandler());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500, 250);
		listModel = checkTable(conn);
		list.setModel(listModel);
		setVisible(true);

	}

	/**
	 * This method is used for getting data from database, and adding it to list
	 * 
	 * @param conn
	 *            - represents SQL connection
	 * @return
	 */
	public DefaultListModel<String> checkTable(Connection conn) {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager
					.getConnection("jdbc:sqlite:C:/Users/Mladen13/Desktop/database/products.db");
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

		DefaultListModel<String> list = new DefaultListModel<>();
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from product");

			while (result.next()) {
				String code = result.getString(1);
				String name = result.getString(2);
				double price = result.getInt(3);

				Product p = new Product();
				p.setCode(code);
				p.setName(name);
				p.setPrice(price);
				list.addElement(p.getCode() + " " + p.getName() + " "
						+ p.getPrice());
				codeList.add(p.getCode());
			}
		} catch (SQLException e1) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e1.getMessage());
			System.exit(1);
		}
		return list;
	}

	/**
	 * This class implements action listener and it is used for deleting
	 * selected data when button delete is clicked.
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
						.getConnection("jdbc:sqlite:C:/Users/Mladen13/Desktop/database/products.db");
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
				Statement statement = conn.createStatement();
				int selectedIndex = list.getSelectedIndex();
				if (selectedIndex != -1) {
					listModel.remove(selectedIndex);
				}

				String deleteCommand = "DELETE FROM product WHERE code='"
						+ codeList.get(selectedIndex) + "'";
				codeList.remove(selectedIndex);
				statement.executeUpdate(deleteCommand);

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new GuiDelete();
	}

}
