package ba.bitcamp.safe;

public class Safe {

	private String name;
	private Integer currentSum;

	// Creating constructor for safe name
	public Safe(String name) {
		this.name = name;
		currentSum = 0;
	}

	/**
	 * <h1>This method will add money to safe.</h1>
	 * <p>
	 * 
	 * @param money
	 *            - represents money added to safe
	 */
	public void addToSafe(int money) {
		currentSum += money;
	}

	/**
	 * This method will clear our safe
	 */
	public void clear() {
		currentSum = 0;
	}

	/**
	 * This method will print informations about quantity of money in safe.
	 */
	public void printInformation() {
		if (currentSum == 0 || currentSum < 0) {
			System.out.println("Safe is empty!");
		} else if (currentSum > 0 && currentSum <= 20) {
			System.out.println("There's some, but not much.");
		} else if (currentSum > 20 && currentSum <= 100) {
			System.out.println("There's some!");
		} else {
			System.out.println("There's a lot");
		}
	}

}
