package ba.bitcamp.homework25.task2;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * This class simulates insertion data into database using GUI
 * 
 * @author Mladen13
 *
 */
public class GuiInsert extends JFrame {

	private static final long serialVersionUID = 2705631766815091095L;

	private JButton insert = new JButton("Insert product");
	private JTextField codeField = new JTextField();
	private JTextField nameField = new JTextField();
	private JTextField priceField = new JTextField();

	private JLabel codeLabel = new JLabel("Code:");
	private JLabel nameLabel = new JLabel("Name:");
	private JLabel priceLabel = new JLabel("Price:");
	private ArrayList<Product> list = new ArrayList<>();

	private Connection conn = null;

	/**
	 * Default constructor that adds components to field
	 */
	public GuiInsert() {
		setLayout(new GridLayout(4, 2));
		add(codeLabel);
		add(codeField);
		codeField.setPreferredSize(new Dimension(100, 50));
		add(nameLabel);
		add(nameField);
		nameField.setPreferredSize(new Dimension(100, 50));
		add(priceLabel);
		add(priceField);
		priceField.setPreferredSize(new Dimension(100, 50));
		add(insert);
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
	 * This class handles insertion logic to database. When button insert is
	 * clicked, data will be stored to database.
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
				// Prikaz kreirane tabele (komanda pokrenuta samo prvi put)
				//String createTableCommand = "CREATE TABLE product (code varchar(20), name varchar(40), price decimal)";				
				// statement.executeUpdate(createTableCommand);

				String code = codeField.getText();
				String name = nameField.getText();

				list = SelectCommand.checkTable(conn);

				if (isValidInsertion(list, code, name) && code.length() == 10
						&& tryParse(code)) {

					String insertCommand = "INSERT INTO product VALUES('"
							+ code + "', '" + name + "',"
							+ priceField.getText() + ")";

					statement.executeUpdate(insertCommand);
				} else {
					System.err
							.println("Code should have 10 elements or your code has wrong format!");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
     /**
      * This method is used for checking if code characters are numbers
      * @param code - inserted code
      * @return - false if it is not a number, otherwise true
      */
	public boolean tryParse(String code) {
		try {
			Integer.parseInt(code);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
    /**
     * This method checks if the same code or name is found in database, as code or name inserted. 
     * @param products - array list of products
     * @param code - inserted code
     * @param name - product name
     * @return
     */
	public boolean isValidInsertion(ArrayList<Product> products, String code,
			String name) {
        //If inserted code is found in list, it will return false
		for (int i = 0; i < list.size(); i++) {
			if (products.get(i).getCode().equals(code)) {
				System.err.println("Code already exists");
				return false;
			}
            //If same name is found in database, confirm dialog will be opened
			if (products.get(i).getName().equals(name)) {
				int choice = JOptionPane.showConfirmDialog(null,
						"Are you sure that you want to insert this product?");
				if (choice == JOptionPane.YES_OPTION) {
					return true;
				} else {
					return false;
				}
			}
		}
		return true;
	}
}

