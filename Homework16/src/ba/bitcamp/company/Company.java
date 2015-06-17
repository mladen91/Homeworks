package ba.bitcamp.company;

public class Company {

	private String companyName;
	private Employee companyDirector;
	private Employee[] workers;

	// Making a constructor for Company
	public Company(String companyName, Employee companyDirector,
			Employee[] workers) {
		this.companyName = companyName;
		this.companyDirector = companyDirector;
		this.workers = workers;
	}

	/**
	 * <h1>We will get number of employees including director in this method</h1>
	 * <p>
	 * 
	 * @return Number of employees
	 */
	public int getNumOfEmployees() {
		return workers.length + 1;
	}

	/**
	 * <h1>We will get salary for all employees including director in this
	 * method</h1>
	 * <p>
	 * 
	 * @param sum
	 *            - represents sum of all salaries in company
	 * @return Salary of all employees
	 */
	public int getSalaryForAllWorkers() {
		int sum = 0;
		for (int i = 0; i < workers.length; i++) {
			sum += workers[i].getSalary();
		}
		return sum + companyDirector.getSalary();

	}

	/**
	 * <h1>We will get number of women in company (director can be woman also)</h1>
	 * <p>
	 * 
	 * @return Number of females in company
	 */
	public int getNumOfFemales() {
		int counter = 0;
		for (int i = 0; i < workers.length; i++) {
			if (workers[i].getGender().equals("Female")) {
				counter++;
			}
		}
		if (companyDirector.getGender().equals("Female")) {
			counter++;
		}
		return counter;
	}

	/**
	 * <h1>We will add salaries to all employees using this method</h1>
	 * <p>
	 * 
	 * @param value
	 *            - represents added salary
	 */
	public void addSalary(int value) {
		for (int i = 0; i < workers.length; i++) {
			workers[i].setSalary(value);
		}
		companyDirector.setSalary(value);
	}

	/**
	 * This method will print name of company, director name and number of
	 * workers
	 */
	public String toString() {
		String s = "";
		int allWorkers = workers.length + 1;
		s = "Name of Company: \n" + companyName;
		s = s + "\nDirector name: " + companyDirector.getName();
		s = s + "\nNumber of workers in company: " + allWorkers;
		return s;
	}
}
