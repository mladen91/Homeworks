package ba.bitcamp.homeworkweekend06.task05;

public class Task5 {

	public static void main(String[] args) {

		System.out.println(getPower(2, 5));
		System.out.println(getPower(-2, 4));
		System.out.println(getPower(-2, -2));

	}

	/**
	 * Recursive method that calculates square of one number
	 * <p>
	 * @param i - represents base
	 * @param j - represents exponent
	 * @return - result
	 */
	private static double getPower(double i, double j) {

		// If exponent reaches zero return 1
		if (i == 0 && j == 0) {
			throw new ArithmeticException("Both base and exp cannot be 0.");
		}
		if (i == 0) {
			return 0;
		}
		if (j == 0) {
			return 1;
		}
		
		if (j < 0) {
			return (1 / i) * getPower(1 / i, -j - 1);
		} else {		
			return i * getPower(i, j - 1);
		}
	}

}
