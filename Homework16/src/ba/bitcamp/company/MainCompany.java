package ba.bitcamp.company;

public class MainCompany {

	public static void main(String[] args) {

		// Creating Employees
		Employee e0 = new Employee("Direktor", "Male", 2600);
		Employee e1 = new Employee("Neki Covjek", "Male", 800);
		Employee e2 = new Employee("Neka Zena", "Female", 800);
		Employee e3 = new Employee("Neka Zena1", "Female", 800);
		// Creating array of employees without director
		Employee[] employees = new Employee[3];
		employees[0] = e1;
		employees[1] = e2;
		employees[2] = e3;

		// Creating company
		Company c1 = new Company("Firma", e0, employees);
		// Adding salary to all employees including director
		c1.addSalary(100);
		System.out.println(c1);
		// Printing number of females in company
		System.out.println("Number of females in company: "
				+ c1.getNumOfFemales());
		// Printing salary of all workers
		System.out.println("Salary of all workers (including director): "
				+ c1.getSalaryForAllWorkers());

	}

}
