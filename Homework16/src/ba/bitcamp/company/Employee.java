package ba.bitcamp.company;

public class Employee {

	private String personName;
	private String gender;
	private int monthlySalary;

	// Creating a constructor for Employees
	public Employee(String personName, String gender, int monthlySalary) {
		this.personName = personName;
		this.gender = gender;
		this.monthlySalary = monthlySalary;
	}

	/**
	 * <h1>We will get employee name using this method</h1>
	 * 
	 * @return Employee name
	 */
	public String getName() {
		return personName;
	}

	/**
	 * <h1>We will get employee gender using this method</h1>
	 * 
	 * @return Employee gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * <h1>We will get employee salary using this method</h1>
	 * 
	 * @return Employee salary
	 */
	public int getSalary() {
		return monthlySalary;
	}

	/**
	 * <h1>We will set employee salary using this method</h1>
	 * 
	 * @return New salary
	 */
	public void setSalary(int value) {
		monthlySalary += value;
	}

}
