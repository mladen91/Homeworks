package ba.bitcamp.homework25.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * This class only contains method that returns arraylist of product from database
 * @author Mladen13
 *
 */
public class SelectCommand {
    /**
     * Method that returns arraylist of products from database
     * @param conn represents sql connection
     * @return
     */
	public static ArrayList<Product> checkTable(Connection conn) {
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

		ArrayList<Product> list = new ArrayList<>();
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
				list.add(p);
			}
		} catch (SQLException e1) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e1.getMessage());
			System.exit(1);
		}
		return list;
	}
}

