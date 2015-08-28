package ba.bitcamp.homework25.task2;

/**
 * This class represent one product that has code, name and price attributes
 * 
 * @author Mladen13
 *
 */
public class Product {

	private String code;
	private String name;
	private double price;

	/**
	 * Getting code from datase
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setting code using JtextField to database
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Getting product name from database
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setting product name for inserting it to database
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getting price from database
	 * 
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Setting price into database
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}

